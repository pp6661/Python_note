def add(x,y):
    result=x+y
    print(f"{x}+{y}的计算结果是：{result}")
add(1,2)
add(5,6)

def add(x,y):
    """
    :param x:形参x表示相加的其中一个数字
    :param y:形参y表示相加的另一个数字
    :return: 返回值是2数的相加结果
    """
    result=x+y
    print(f"2数相加的结果是：{result}")
    return result
add(5,6)

#变量
#全局变量
# num=200
# def test_a():
#     print(f"test_a:{num}")
# def test_b():
#     print(f"test_b:{num}")
#
# test_a()
# test_b()
# print(num)

#在函数内修改全局变量
# num=200
# def test_a():
#     print(f"test_a:{num}")
# def test_b():
#     num=500 #局部变量
#     print(f"test_b:{num}")
#
# test_a()
# test_b()
# print(num)

#global关键字，在函数内申明变量为全局变量
num=200
def test_a():
    print(f"test_a:{num}")
def test_b():
    global num
    num=500 #在函数内申明变量为全局变量
    print(f"test_b:{num}")

test_a()
test_b()
print(num)

# 所谓“返回值”，就是程序中函数完成事情后，最后给调用者的结果
def add(a,b):
    result=a+b
    #通过返回值，将相加的结果返回给调用者
    return result
#函数返回值，可通过变量去接收
r=add(5,6)
print(r)

# None作为一个特殊的字面量，用于表示：空、无意义，其有非常多的应用场景：
# - 用在函数无返回值上
def say_hi():
    print("hello")
result=say_hi()
print(f"无返回值函数，返回的内容是{result}")

def say_hi2():
    print("hi")
    return None
result=say_hi2()
print(f"无返回值函数，返回的内容是{result}")
# - 用在if判断上
#   - 在if判断中，None等同于False
#   - 一般用于在函数中主动返回None，配合if判断做相关处理
def check_age(age):
    if age>=18:
        return "success"
    else:
        return None
result=check_age(18)
if not result:
    #进入if表示result是None值，False
    print("未成年")


# - 用于声明无内容的变量上
#   - 定义变量，但暂时不需要变量有具体值，可以用None来代替
name=None

