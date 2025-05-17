import numpy as np
import pandas as pd

print("------------数据清洗-------------------")
df = pd.read_csv("D:\数分资料\资料\OnlineRetail.csv\OnlineRetail.csv", encoding='utf-8')

print("DataFrame的长度:", len(df))
print("抽样数据:")
print(df.sample(10))
# 负数异常数据剔除
df = df[(df.Quantity > 0) & (df.UnitPrice > 0)]
# 查看同一股票代码的不同产品描述有多少种
print(df.groupby('StockCode').Description.nunique().sort_values(ascending=False))  # 表示降序排列
# 剔除异常产品数据
df = df[~df.StockCode.isin(['POST', 'DOT', 'M', 'AMAZONFEE', 'BANK CHARGES', 'C2', 'S'])]
print(len(df))
# 清洗控制变量
df['InvoiceDate'] = pd.to_datetime(df.InvoiceDate)  # 将 DataFrame df 中名为 'InvoiceDate' 的列转换为标准的日期时间 (datetime) 数据类型。
df['Date'] = pd.to_datetime(df.InvoiceDate.dt.date)  # 从已经处理好的 'InvoiceDate' 列中提取出纯日期部分（不包含时间信息），并将其作为一个新的列 'Date'
# 添加到 DataFrame 中。
df['revenue'] = df.Quantity * df.UnitPrice  # 计算每一笔交易（或每一件商品）的收入，并将其作为一个新的列 'revenue' 添加到 DataFrame 中。

# 查看数据趋势  # .agg在分组后，对每个组（即每一天）执行聚合操作
df.groupby('Date').agg({'Quantity': 'sum', 'revenue': 'sum'}).plot(
    title='number of items sold and number of orders over time',
    secondary_y='Quantity',  # 用于创建双 Y 轴图表
    figsize=(16, 5)  # 设置图表的尺寸宽，高
)
# plt.show()

df.groupby('Date').agg({'Quantity': 'sum', 'revenue': 'sum', 'InvoiceNo': 'nunique'}).plot(
    title='number of items sold and number of orders over time',
    secondary_y='InvoiceNo',
    figsize=(16, 5)
)
# plt.show()

# 剔除异常偏差值
df = (
    df.assign(dNormalPrice=lambda d: d.UnitPrice / d.groupby('StockCode').UnitPrice.transform('median')
              # 先按 StockCode 分组，计算每个商品的中位数价格，再用每行的 UnitPrice 除以对应组的中位数，得到一个新的列 dNormalPrice，表示该行价格与同一商品“典型”价格（中位数）之比
              ).pipe(lambda d: d[(d['dNormalPrice'] > 1. / 3) & (d['dNormalPrice'] < 3.)]
                     # 通过 pipe 将上一步产生的 DataFrame 传给 lambda，只保留那些相对价格比值 dNormalPrice 在 (1/3,
                     # 3) 之间的行，即价格不低于中位数的三分之一，也不高于中位数的三倍。这样可剔除极端异常的低价或高价记录。
                     ).drop(columns=['dNormalPrice'])  # 把中间产生的辅助列 dNormalPrice 删除
)
df = df.groupby(['Date', 'StockCode', 'Country'], as_index=False).agg({
    'Description': 'first',
    'Quantity': 'sum',
    'revenue': 'sum'
})
df['Description'] = df.groupby('StockCode').Description.transform('first')
df['UnitPrice'] = df['revenue'] / df['Quantity']
# 清洗完毕，数据保存为parquet
df.to_parquet('ecom_sample_clean.parquet')

print("------------建立模型-----------")
# 读取数据
df = pd.read_parquet('ecom_sample_clean.parquet')
df.set_index(['Date', 'StockCode', 'Country']).sample(5)
print(df.set_index(['Date', 'StockCode', 'Country']).sample(5))

# 每组的 UnitPrice 计算标准差（std），并把每个组对应的标准差值“广播”回原 DataFrame 的每一行，产生一个与 df 等长的序列。
df_mdl = df[(df.groupby('StockCode').UnitPrice.transform('std') > 0)]
del df
# 将单价和数量取log
df_mdl = df_mdl.assign(
    LnP=np.log(df_mdl['UnitPrice']),
    LnQ=np.log(df_mdl['Quantity']),
)
print(df_mdl.head())

print("------------------查看 lnQ 和 lnP 相关关系---------------------")
# 方法一：通过计算方差得到相关系数
print(df_mdl[['LnP', 'LnQ']].cov())
# 若 Cov(LnP, LnQ) < 0，说明 LnP ↑ 时 LnQ ↓，即价格与销量呈负相关。
# 若 Cov(LnP, LnQ) > 0，则二者正相关。

# 方法二：通过回归计算得到 LnP 回归系数 =-0.6064
import statsmodels.api as sm  # get full stats on regressions


# binned_ols 函数的核心思路是：先对解释变量做分箱（binning），再在每个箱子里取解释变量和被解释变量的“箱内均值”来回归或作图——本质上是一种“可视化降噪”（de-noising）技巧
def binned_ols(df, x, y, n_bins, plot=True, plot_title='', plot_ax=None, **plt_kwargs):
    # A visual form of de-noising: bin explanatory variable first,
    # then take means-per-bin of variable to be explained, then regress/plot
    x_bin = x + '_bin'
    df[x_bin] = pd.qcut(df[x], n_bins)  # 会把 x 按分位数分成 n_bins 份（每个箱子大致包含相同数量的样本），生成一个表示区间的 Categorical 列。

    tmp = df.groupby(x_bin).agg({
        x: 'mean',  # 均值
        y: 'mean'
    })

    if plot:
        tmp.plot(
            x=x,
            y=y,
            figsize=(18, 6),
            title=plot_title,
            ax=plot_ax,
            **plt_kwargs
        )

    del df[x_bin]
    mdl = sm.OLS(tmp[y], sm.add_constant(tmp[x]))  # sm.OLS 表示使用 statsmodels 库中的普通最小二乘法（Ordinary Least Squares）模型。
    res = mdl.fit()
    return res


ols_fit = binned_ols(
    df_mdl,
    x='LnP',
    y='LnQ',
    n_bins=15,
    plot_title='Observe messy relationship between LnP and LnQ'
)

print(f'"Naive" elasticity estimated to be {ols_fit.params["LnP"]}')
ols_fit.summary()

# 尝试换成柏松回归和正则化的Ridge—OLS回归方法
from sklearn import linear_model
from sklearn.pipeline import Pipeline
from sklearn.compose import ColumnTransformer
from sklearn.preprocessing import OneHotEncoder, StandardScaler
from sklearn.feature_extraction.text import CountVectorizer

feature_generator_basic = ColumnTransformer(
    [
        ('StockCode', OneHotEncoder(), ['StockCode']),
        ('Date', OneHotEncoder(), ['Date']),
        ('Country', OneHotEncoder(), ['Country']),
        ('LnP', 'passthrough', ['LnP']),
    ], remainder='drop'
)

mdl_basic = Pipeline([
    ('feat_proc', feature_generator_basic),
    ('reg', linear_model.PoissonRegressor(
        alpha=1e-6,  # l2 penalty strength; manually selected value for minimum interference on LnP-coef (elasticity)
        fit_intercept=False,  # no need, since we have OneHot encodings without drop
        max_iter=100_000,
    )),
], verbose=True)

mdl_basic_ols = Pipeline([
    ('feat_proc', feature_generator_basic),
    ('reg', linear_model.Ridge(
        alpha=1e-20,  # l2 penalty strength, "very small"
        fit_intercept=False,
        max_iter=100_000,
    )),
], verbose=True)
mdl_basic.fit(
    df_mdl[['LnP', 'StockCode', 'Date', 'Country']],
    df_mdl['Quantity']  # Poisson regression has log-link, so LnQ is implicit in loss function
)

mdl_basic_ols.fit(
    df_mdl[['LnP', 'StockCode', 'Date', 'Country']],
    df_mdl['LnQ']  # log-normal
)

# 接下来算需求量 Q 对价格 P 的弹性关系
df_mdl['dLnP'] = np.log(df_mdl.UnitPrice) - np.log(df_mdl.groupby('StockCode').UnitPrice.transform('mean'))
df_mdl['dLnQ'] = np.log(df_mdl.Quantity) - np.log(df_mdl.groupby('StockCode').Quantity.transform('mean'))
print(df_mdl[['dLnP', 'dLnQ']].cov())

# 第二步计算衍生特征
df_mdl = df_mdl.assign(
    month=lambda d: d.Date.dt.month,
    DoM=lambda d: d.Date.dt.day,
    DoW=lambda d: d.Date.dt.weekday,
    stock_age_days=lambda d: (d.Date - d.groupby('StockCode').Date.transform('min')).dt.days,
    sku_avg_p=lambda d: d.groupby('StockCode').UnitPrice.transform('median')
)

# 用混杂变量预测价格 P 和需求量 Q
from sklearn.ensemble import RandomForestRegressor

feature_generator_full = ColumnTransformer(
    [
        # do NOT include to reduce overfit (price is sku-level-demeaned anyway):
        # ('StockCode', OneHotEncoder(), ['StockCode']),
        ('Date', OneHotEncoder(), ['Date']),
        ('Description', CountVectorizer(min_df=0.0025, ngram_range=(1, 3)), 'Description'),
        ('Country', OneHotEncoder(), ['Country']),
        ('numeric_feats', StandardScaler(), ['month', 'DoM', 'DoW', 'stock_age_days', 'sku_avg_p']),
    ], remainder='drop'
)
model_y = Pipeline([
    ('feat_proc', feature_generator_full),
    ('model_y', RandomForestRegressor(n_estimators=50, min_samples_leaf=3, n_jobs=-1, verbose=0))
    # n_samples_leaf/n_estimators is set to reduce model (file) size and runtime
    # larger models yield prettier plots.
])
model_t = Pipeline([
    ('feat_proc', feature_generator_full),
    ('model_t', RandomForestRegressor(n_estimators=50, min_samples_leaf=3, n_jobs=-1, verbose=0))
])
import joblib

try:  # load existing models, if possible
    model_y = joblib.load('models/step1_model_y.joblib')
    model_t = joblib.load('models/step1_model_t.joblib')
except:
    print('No pre-existing models found, fitting aux models for y and t')
    model_y.fit(df_mdl, df_mdl.dLnQ)
    model_t.fit(df_mdl, df_mdl.dLnP)

    joblib.dump(model_y, 'models/step1_model_y.joblib', compress=True)
    joblib.dump(model_t, 'models/step1_model_t.joblib', compress=True)
# Get first-step, predictions to residualize ("orthogonalize") with (in-sample for now)
q_hat = model_y.predict(df_mdl)
p_hat = model_t.predict(df_mdl)

# 用观测值减去预测得到的值求解残差

# 用残差拟合OLS回归模型得到回归系数为 -1.819，和之前去均值化后的ols模型结果 -1.7 比较，二者的斜率还是有一定的差异
# 初始ols模型

# 初始去均值化后的ols模型

# 残差拟合的ols模型
