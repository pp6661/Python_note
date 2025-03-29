import pandas as pd
import numpy as np

dates = pd.date_range('20130102', periods=6)
df = pd.DataFrame(np.arange(24).reshape((6, 4)), index=dates, columns=['A', 'B', 'C', 'D'])
# print(df['A']) #print(df.A)

# select by label:loc  通过索引标签（如 '2013-01-02'）和列名（如 'A'）访问数据。
# print(df.loc['20130102'])
# print(df.loc['20130102':, ['A', 'B']])

# select by position: iloc  通过行号（如 0,1,2）和列号（如 0,2）访问数据。
# print(df.iloc[3,1]) #第三行第一位
# print(df.iloc[[1,3,5],1:3])

# mixed selection:
# print(df.iloc[:3, [0,2]])

# Boolean indexing
print(df)
print(df[df.A>8])
