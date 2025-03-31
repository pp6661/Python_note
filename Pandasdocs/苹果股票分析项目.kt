import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

apple = pd.read_csv("D:\数分资料\资料/11_苹果股票分析项目\AAPL.csv")
pd.set_option('display.max_columns', None)

print(apple.shape)
print(apple.head())
print(apple.tail())

# 随机查看数据
print(apple.sample(n=10))
print(apple.sample(frac=0.001))  # 取总样本的0.1%

# 检查数据类型
print(apple.dtypes)
print(apple.info())  # 可查看数据量非空
print(apple.describe())

# 将date这列数据转换为时间数据
apple['Date']=pd.to_datetime(apple.Date)
print(apple.dtypes)

# 设置Date为行索引
apple2=apple.set_index(keys='Date')
print(apple2.head())

# 绘制图形:收盘价格
apple2['Adj Close'].plot()
plt.show()
