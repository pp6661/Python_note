# import my_package.my_module1
# import my_package.my_module2
#
# my_package.my_module1.info_print1()
# my_package.my_module2.info_print2()

# from my_package import my_module1
# from my_package import my_module2
# my_module1.info_print1()
# my_module2.info_print2()

# from my_package.my_module1 import info_print1
# from my_package.my_module2 import info_print2
# info_print1()
# info_print2()

from my_package import*
my_module1.info_print1()
my_module2.info_print2()

#异常的传递
def func1():
    print("func1 start")
    num=1/0
    print("func1 end")

def func2():
    print("func2 start")
    func1()
    print("func1 end")
    
def main():
    try:
        func2()
    except Exception as e:
        print(f"bug {e}")
main()

# 基本语法：
# try:
# 可能发生错误的代码
# except:
# 如果出现异常执行的代码
# try:
#     f=f=open("D:/123.txt","r",encoding="UTF-8")
# except:
#     f=open("D:/123.txt","w",encoding="UTF-8")

#捕获指定异常
# try:
#     print(name)
# except NameError as e:
#     print('name变量名称未定义错误')p

#捕获多个异常：
# try:
#     print(name)
# except (NameError,ZeroDivisionError) as e:
#     print('name变量名称未定义错误 or ZeroDivisionError')

#捕获所以异常：
try:
    f = open("D:/123.txt", "w", encoding="UTF-8")
except Exception as e:
    print("出现异常")
else:
    print("without bug")
finally:
    f.close()

# 这是Python中导入模块的语法介绍，以下是提取的内容：
# - 导入语法：`[from 模块名] import [模块 | 类 | 变量 | 函数 | *] [as 别名]`
# - 常用组合形式：
#   my_package. `import 模块名`
#   2. `from 模块名 import 类、变量、方法等`
#   3. `from 模块名 import *`
#   4. `import 模块名 as 别名`
#   5. `from 模块名 import 功能名 as 别名`


# my_package. 使用`import`导入`time`模块使用`sleep`功能（函数）
# import time
# print("hello")
# time.sleep(5) #通过.可以使用模块内部的全部功能（类，函数，变量）
# print("hi")

# 2. 使用`from`导入`time`的`sleep`功能（函数）
from time import sleep
print("hi")
sleep(5)
print("hello")

# 3. 使用`*` 导入`time`模块的全部功能
# from time import* #*表示全部
# print("hi")
# sleep(5)
# print("hello")

# 4. 使用`as`给特定功能加上别名
import time as t
print("hi")
t.sleep(5)
print("hello")

from time import sleep as sl
print("hi")
sl(5)
print("hello")

#自定义模块
# import my_module1
# my_module1.test(my_package,2)

# from my_module1 import test
# test(my_package,2)

#__all__变量
from my_module1 import *
test1(1,2)
test2(1,2)
