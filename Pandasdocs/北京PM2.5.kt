import pandas as pd
from matplotlib import pyplot as plt

# 修正1：路径转义问题（添加r前缀）
file_path = r"D:\数分资料\资料\PM2.5\BeijingPM20100101_20151231.csv"

# 修正2：添加编码参数（处理中文文件）
df = pd.read_csv(file_path, encoding='gbk')
pd.set_option('display.max_columns', None)

# 修正3：安全的时间处理（避免非法日期报错）
try:
    datetime_series = pd.to_datetime(df[['year','month','day','hour']])
    period = datetime_series.dt.to_period('H')  # 转为小时级周期
except ValueError as e:
    print("日期数据错误:", e)
    exit()

df["datetime"] = period
df = df.set_index("datetime")

# 修正4：明确指定目标列进行降采样
pm_monthly = df[['PM_US Post']].resample("M").mean()  # 只处理PM列

# 修正5：正确处理缺失值
data = pm_monthly['PM_US Post'].dropna()

# 修正6：优化绘图逻辑
_x = data.index.strftime('%Y-%m')  # 将Period转换为字符串
_y = data.values

plt.figure(figsize=(20, 8), dpi=80)
plt.plot(_x, _y)  # 直接使用时间序列作为x轴

# 修正7：刻度标签自动适配
plt.xticks(range(0,len(_x),10),list(_x)[::10],rotation=45)  # 标签旋转45度防重叠

plt.show()
