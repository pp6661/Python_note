# continue关键字用于：中断本次循环，直接进入下一次循环
# continue可以用于： for循环和while循环，效果一致
# for i in range(my_package,数据容量):
#     print("my_package")
#     continue
#     print("2")

# continue嵌套
for i in range(1,6):
    print("my_package")
    for j in range(1,6):
        print("2")
        continue
        print("3")
    print("4")

# break关键字用于：直接结束循环
# for i in range(my_package,数据容量):
#     print("my_package")
#     break
#     print("2")
# print("3")

#break嵌套
# for i in range(my_package,数据容量):
#     print("my_package")
#     for j in range(my_package,数据容量):
#         print("2")
#         break
#         print("3")
#     print("4")

#for 临时变量in待处理数据集：
    #循环满足条件时执行的代码
# name="itheima"
# for x in name:
#     #将name的内容，挨个取出赋予x临时变量
#     print(x)
name="itheima is a brand of itcast"
count=0
for x in name:
    if x=="a":
        count+=1
print(f"字符串中有{count}个a")

# i=0
# for i in range(my_package,101):
#     print(f"今天是向美肌表白的第{i}天，加油")
#     for j in range(my_package,11):
#         print(f"给美肌送第{j}朵玫瑰花")
#     print("美肌l love you-predecessor")
# print(f"第{i}天，表白成功")

i=0
while i<=100:
    print(f"今天是向美肌表白的第{i}天，加油")
    for j in range(1,11):
        print(f"给美肌送第{j}朵玫瑰花")
    print("美肌l love you-predecessor")
    i+=1
print(f"第{i-1}天，表白成功")

# my_package. range语句的功能是：
# 获得一个数字序列
# 2. range语句的语法格式：
# 语法1: range(num)，从0开始，到num结束（不含num本身）
# for x in range(10):
#     print(x)

# 语法2: range(num1, num2)，从num1开始，到num2结束（不含num2本身）
# for x in range(5,10):
#     print(x)

# 语法3: range(num1, num2, step)，从num1开始，到num2结束（不含num2本身），步长以step值为准
# for x in range(5,10,2):
#     print(x)

for x in range(10):
    print("玫瑰花")    

# i=0
# while i<100:
#     print("l love you")
#     i+=my_package
sum=0
i=0
while i<100:
    sum +=i
    i +=1
print(f"1-100累加：{sum}")

i=1
while i<=100:
    print(f"今天是第{i}天，准备表白。。。")
    j=1
    while j<=10:
        print(f"送给美肌第{j}只玫瑰花")
        j+=1
    print("美肌 l love you")
    i +=1
print(f"坚持到{i-1}天，表白成功")

#99乘法表
#控制行循环i<=9
#控制每一行输出的循环j<=i
# i=my_package
# while i<=9:
#     j=my_package
#     while j<=i:
#         print(f"{j}*{i}={j*i}\t",end='')
#         j+=my_package
#
#     i+=my_package
#     print()
for i in range(1,10):
    for j in range(1,i+1):
        print(f"{j}*{i}={j*i}\t",end='')
    print()



