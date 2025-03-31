import numpy as np

a0 = np.array([2, 23, 4], dtype=np.int_)
print(a0.dtype)
print("-------")

b1 = np.array([[2, 23, 4],
               [2, 23, 4]])
print(b1)
print("-------")

# b2 = np.zeros((3,4))
# print(b2)
# print("-------")

# b3 = np.ones((3,4))
# print(b3)
# print("-------")

b4 = np.empty((3, 4))
print(b4)
print("-------")

a1 = np.arange(10, 20, 2)
print(a1)
print("-------")

a2 = np.arange(12).reshape((3, 4))
print(a2)
print("-------")

a3 = np.linspace(1, 10, 6).reshape((2, 3))
print(a3)
print("-------")
