import pandas as pd
import numpy as np

# merging two df by key/keys.(may be used in database)
# simple example
# left=pd.DataFrame({'key':['K0','K1','K2','K3'],
#                    'A':['A0','A1','A2','A3'],
#                    'B':['B0','B1','B2','B3']})
# right=pd.DataFrame({'key':['K0','K1','K2','K3'],
#                     'C': ['C0', 'C1', 'C2', 'C3'],
#                     'D': ['D0', 'D1', 'D2', 'D3']
#                     })
# print(left)
# print(right)
# res=pd.merge(left,right,on='key',how='inner')
# print(res)

#consider two keys
# left = pd.DataFrame({'key1': ['K0', 'K0', 'K1', 'K2'],
#                              'key2': ['K0', 'K1', 'K0', 'K1'],
#                              'A': ['A0', 'A1', 'A2', 'A3'],
#                              'B': ['B0', 'B1', 'B2', 'B3']})
# right = pd.DataFrame({'key1': ['K0', 'K1', 'K1', 'K2'],
#                               'key2': ['K0', 'K0', 'K0', 'K0'],
#                               'C': ['C0', 'C1', 'C2', 'C3'],
#                               'D': ['D0', 'D1', 'D2', 'D3']})
# print(left)
# print(right)
# print(right)
# # how = ['left', 'right', 'outer', 'inner']
# res=pd.merge(left,right,on=['key1','key2'],how='outer')
# print(res)

# indicator
# df1 = pd.DataFrame({'col1':[0,1], 'col_left':['a','b']})
# df2 = pd.DataFrame({'col1':[1,2,2],'col_right':[2,2,2]})
# print(df1)
# print(df2)
# # res = pd.merge(df1, df2, on='col1', how='outer', indicator=True)
#
# # give the indicator a custom name
# res = pd.merge(df1, df2, on='col1', how='outer', indicator='indicator_column')
# print(res)

# merged by index
left = pd.DataFrame({'A': ['A0', 'A1', 'A2'],
                                  'B': ['B0', 'B1', 'B2']},
                                  index=['K0', 'K1', 'K2'])
right = pd.DataFrame({'C': ['C0', 'C2', 'C3'],
                                     'D': ['D0', 'D2', 'D3']},
                                      index=['K0', 'K2', 'K3'])
print(left)
print(right)
# left_index and right_index
# res = pd.merge(left, right, left_index=True, right_index=True, how='outer')
res = pd.merge(left, right, left_index=True, right_index=True, how='inner')
print(res)

# handle overlapping
boys = pd.DataFrame({'k': ['K0', 'K1', 'K2'], 'age': [1, 2, 3]})
girls = pd.DataFrame({'k': ['K0', 'K0', 'K3'], 'age': [4, 5, 6]})
res = pd.merge(boys, girls, on='k', suffixes=['_boy', '_girl'], how='inner')
print(res)
