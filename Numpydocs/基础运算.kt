import numpy as np

a = np.array([10, 20, 30, 40])
b = np.arange(4)  # 0 1 2 3
print(a, b)

c = a - b
print(c)

c1 = a ** 2
print(c1)

c2 = 10 * np.sin(a)  # 10的sin值*10
print(c2)

c3 = 10 * np.cos(a)  # 10的cos值*10
print(c3)

print(b)
print(b < 3)

a1 = np.array([[1, 1],
              [0, 1]])
b2 = np.arange(4).reshape((2, 2))
c4 = a1 * b2  #逐个相乘
c4_dot=np.dot(a1, b2)  #c4_dot=a1.dot(b2)
#线性代数矩阵相乘
# C[0,0]：A的第一行[1,1]与B的第一列[0,2]点积：
# 1×0+1×2=2
# 1×0+1×2=2
# C[0,1]：A的第一行[1,1]与B的第二列[1,3]点积：
# C[1,0]：A的第二行[0,1]与B的第一列[0,2]点积：
# C[1,1]：A的第二行[0,1]与B的第二列[1,3]点积：

print(c4)
print(c4_dot)

d=np.random.random((2,4))
print(d)
print(np.sum(d,axis=1))#行
print(np.min(d,axis=0))#列
print(np.max(d,axis=1))

