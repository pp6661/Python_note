#函数多返回值
def test_return():
    return 1,"hello",True
x,y,z=test_return()
print(x)
print(y)
print(z)


# 演示多种传参的形式
def user_info(name,age,gender):
    print(f"{name},{age},{gender}")
# 位置参数 - 默认使用形式
user_info("xiaoming",20,"male")
# 关键字参数
user_info(name="wang",age=11,gender="female")
user_info(age=20,gender="male",name="xx")
user_info("yy",gender="male",age=9)
#  缺省参数（默认值）
def user_info(name,age,gender="male"):#默认值要在最后
    print(f"{name},{age},{gender}")
user_info("tt",19)
user_info("tt",19,gender="female")

# 不定长 - 位置不定长，*号
#不定长定义的形式参数会作为元组存在，接收不定长数量的参数传入
def user_info(*args):
    print(f"{type(args)},{args}")

user_info(1,2,3,"xiaoming","boy")


# 不定长 - 关键字不定长，**号
def user_info(**kwargs):
    print(f"{type(kwargs)},{kwargs}")

user_info(name="xiaoming",age=11,gender="male")

# 演示函数作为参数传递

# 定义一个函数，接收另一个函数作为传入参数
def test_func(computer):
    result=computer(1,2)
    print(f"{type(computer)}")
    print(f"{result}")
# 定义一个函数，准备作为参数传入另一个函数
def computer(x,y):
    return x+y
#  调用，并传入函数
test_func(computer)

# 演示lambda匿名函数

# # 定义一个函数，接受其它函数输入
def test_func(computer):
    result=computer(1,2)
    print(f"{result}")
# # 通过lambda匿名函数的形式，将匿名函数作为参数传入
test_func(lambda x,y:x+y)


