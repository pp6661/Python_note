import pandas as pd
import numpy as np

dates = pd.date_range('20130102', periods=6)
df = pd.DataFrame(np.arange(24).reshape((6, 4)), index=dates, columns=['A', 'B', 'C', 'D'])
df.iloc[0,1]=np.nan
df.iloc[1,2]=np.nan

print(df.dropna(axis=0,how='all')) #how={'anu','all'} any：任何一个有nan丢掉；all：全有nan再丢
print(df.fillna(value=0))  #把nan填值
print(df.isnull())
print(np.any(df.isnull()==True)) #至少有一个丢失
