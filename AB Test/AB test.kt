import pandas as pd
import numpy as np
import statsmodels.api as sm
import statsmodels.formula.api as smf
import matplotlib.pyplot as plt

page_df = pd.read_csv("D:/数分资料/资料/ab_data.csv", encoding='utf-8')
page_df.head()
print('数据行数：', page_df.shape[0])
print('独立用户数：', page_df.user_id.nunique())

# 标记出在该列中出现次数超过 1 次的所有行，返回一个布尔 Series。  将筛选后的结果按照 user_id 列的值升序排序
var = page_df[page_df.user_id.duplicated(keep=False)].sort_values(by='user_id').head(10)
print(var)

# 查看group和landing_page不匹配的数量
mismatch = ((page_df['group'] == 'treatment') != (page_df['landing_page'] == 'new_page'))
print('不匹配数：', mismatch.sum())

# 把不符的数据剔除：即 mismatch == False的行，并复制成一个新的 DataFrame 存到 match_df
match_df = page_df[~mismatch].copy()  # ~表示按位取反
print('数据行数：', match_df.shape[0])
print('独立用户数：', match_df.user_id.nunique())

# 仍旧有重复的用户id，查看：
var1 = match_df[match_df.user_id.duplicated(keep=False)]
print("仍旧有重复的用户id，查看：")
print(var1)
# drop_duplicates(...)删除
# subset=['user_id'] 告诉函数“判断重复”时，只考虑 user_id 这一列：
# keep='last'当有重复时，保留最后一条出现的记录（按 DataFrame 当前排序中的顺序）,其他同一 user_id 的行会被删除。
match_df = match_df.drop_duplicates(subset=['user_id'], keep='last')

# 检查缺失值
var2 = match_df.isnull().sum()
print("检查缺失值:")
print(var2)
print("-------------")
# 收到新页面的用户占比多少
var3 = match_df[match_df.landing_page == "new_page"].shape[0] / match_df.shape[0]
print(f"收到新页面的用户占比为：{var3}")

print("------假设检验-------")
# 假设检验
# 旧版、新版用户数
# group=="control" 或 group=="treatment"：表示是对照组或实验组
n_old = match_df.query('group=="control"').shape[0]
n_new = match_df.query('group=="treatment"').shape[0]
# 旧版、新版转化用户数
convert_old = match_df.query('group=="control" & converted==1').shape[0]
convert_new = match_df.query('group=="treatment" & converted==1').shape[0]
# 旧版、新版转化率
p_old = convert_old / n_old
p_new = convert_new / n_new
print('旧版总受试用户数:', n_old, '旧版转化用户数:', convert_old, '旧版转化率:', p_old)
print('新版总受试用户数:', n_new, '新版转化用户数:', convert_new, '新版转化率:', p_new)

# 计算转化率的联合估计
p_c = (convert_old + convert_new) / (n_old + n_new)
print('转化率的联合估计:', p_c)

z = (p_old - p_new) / np.sqrt(p_c * (1 - p_c) * (1 / n_old + 1 / n_new))
print('检验统计量z:', z)

from scipy.stats import norm

# ppf 是 percent point function（百分位点函数），也叫 逆累积分布函数； 它的作用是：给定概率 p，返回标准正态分布中该概率对应的 Z 值（即横坐标值）；
# norm.ppf(0.05) 表示：“标准正态分布中左边 5% 所对应的 Z 值”。
z_alpha = norm.ppf(0.05)  # 若为双侧，则norm.ppf(0.05/2)

# 合并标准差
std_old = match_df[match_df.landing_page == "old_page"].converted.std()
std_new = match_df[match_df.landing_page == "new_page"].converted.std()
s = np.sqrt(((n_old - 1) * std_old ** 2 + (n_new - 1) * std_new ** 2) / (n_old + n_new - 2))
# 效应量Cohen's d
d = (p_old - p_new) / s
print('Cohen\'s d为：', d)

import statsmodels.stats.proportion as sp

# alternative='smaller'代表左尾
z_score, p_value = sp.proportions_ztest([convert_old, convert_new], [n_old, n_new], alternative='smaller')
print('检验统计量z:', z_score, '，p值:', p_value)

import statsmodels.stats.weightstats as sw

z_score1, p_value1 = sw.ztest(match_df.query('landing_page=="old_page"')['converted'],
                              match_df.query('landing_page=="new_page"')['converted'],
                              alternative='smaller')
print('检验统计量z:', z_score1, '，p值:', p_value1)

# 蒙特卡洛法 计算机模拟多次抽样，获得分布
p_all = match_df.converted.mean()
print('p_all:', p_all)

old_page = np.random.choice(2, size=n_old, p=[1 - p_all, p_all])
new_page = np.random.choice(2, size=n_new, p=[1 - p_all, p_all])
diff = old_page.mean() - new_page.mean()
print('旧版模拟结果：', old_page, '，新版模拟结果：', new_page, '，模拟的转化率差值：', diff)

# 计算ab_data.csv样本的转化率差值
match_diff = match_df[match_df.landing_page == "old_page"]['converted'].mean() - \
             match_df[match_df.landing_page == "new_page"]['converted'].mean()
print('ab_data.csv样本的转化率差值:', match_diff)

diffs = []  # 存放每次模拟的转化率差值

for i in range(10000):  # 成 0/1 随机样本，1 表示转化成功
    p_new_diff = np.random.choice(2, size=n_new, p=[1 - p_all, p_all]).mean()  # 计算模拟样本的平均转化率
    p_old_diff = np.random.choice(2, size=n_old, p=[1 - p_all, p_all]).mean()
    diffs.append(p_old_diff - p_new_diff)  # 保存差值（对照组 - 实验组）

diffs = np.array(diffs)  # 前面收集的列表 diffs 转换为 NumPy 数组，便于后续统计分析。
plt.hist(diffs)  # 画出差值的直方图
plt.axvline(match_diff)  # 在图上画一条垂直线，位置是实观察到的差值
(diffs < match_diff).mean()  # 计算 diffs 中有多少比例的值比真实差值还小

plt.show()
