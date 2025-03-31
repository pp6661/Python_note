import numpy as np

A = np.arange(3, 15).reshape((3, 4))
print(A)
print("------")
print(A[2])  # 索引行数
print(A[1][1])
print(A[2, 1])
print(A[2, :])  # 第二行的所有数
print(A[:, 1])  # 第一列的所有数
print(A[1, 1:2])  # 第一个索引 1：表示第二行（索引从0开始）;
                  # 第二个索引 1:2：表示从第1列到第2列（左闭右开）。对应列的索引范围：8（仅包含第1列，因为 1:2 不包含2

print("------")
for row in A:
    print(row)

for column in A.T:
    print(column)

print(A.flatten())
for item in A.flat:
    print(item)
