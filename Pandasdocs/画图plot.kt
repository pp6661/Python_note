import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

#plot data

#Series
data=pd.Series(np.random.randn(1000),index=np.arange(1000))
data=data.cumsum()

#DataFrame
# data=pd.DataFrame(np.random.randn(1000,4),
#                   index=np.arange(1000),
#                   columns=list("ABCD"))
# data=data.cumsum()
# print(data.head(5))

#plot methods:
# 'bar', 'hist', 'box', 'kde', 'area', scatter', hexbin', 'pie'

ax=data.plot.bar(x='A',y='B',color='DarkBlue',label='class1')
data.plot.bar(x='A',y='C',color='DarkGreen',label='class2',ax=ax)

data.plot()
plt.show()
