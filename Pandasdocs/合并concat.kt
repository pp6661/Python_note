import pandas as pd
import numpy as np

# concatenating
df1 = pd.DataFrame(np.ones((3,4))*0, columns=['a','b','c','d'])
df2 = pd.DataFrame(np.ones((3,4))*1, columns=['a','b','c','d'])
df3 = pd.DataFrame(np.ones((3,4))*2, columns=['a','b','c','d'])
print(df1)
print(df2)
print(df3)
res=pd.concat([df1,df2,df3],axis=0,ignore_index=True)
print(res)

#join,['inner','outer']
df1 = pd.DataFrame(np.ones((3,4))*0, columns=['a','b','c','d'],index=[1,2,3])
df2 = pd.DataFrame(np.ones((3,4))*1, columns=['b','c','d','e'],index=[2,3,4])
print(df1)
print(df2)
res=pd.concat([df1,df2],join='outer') #不同的null
res2=pd.concat([df1,df2],join='inner',ignore_index=True) #不同的裁剪
print(res2)

res3=pd.concat([df1,df2],axis=1).reindex(df1.index) #横向合并后手动筛选索引（保留df1的索引）
print(res3)

#append已弃用，用 pd.concat() 替代 append() 实现纵向合并：
df1 = pd.DataFrame(np.ones((3,4))*0, columns=['a','b','c','d'])
df2 = pd.DataFrame(np.ones((3,4))*1, columns=['a','b','c','d'])
s1 = pd.Series([1,2,3,4],index=['a','b','c','d'])

res4 = pd.concat([df1, df2], ignore_index=True)
res5 = pd.concat([df1, s1.to_frame().T], ignore_index=True) #Series需转换为dataframe 使用 .to_frame().T 转置为行）
print(res5)
