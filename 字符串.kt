#字符串引号定义
name='hei'
print(type(name))
name="hei"
print(type(name))
name="""
hei
hei
"""
print(type(name))

name='"hei"'
print(name)
name="'hei'"
print(name)
#转义字符\解除引号效用
name="\"hei\""
print(name)
name='\'hei\''
print(name)

#格式化
#通过占位方式完成拼接
#"%占位符"%变量
name="hei"
message="学IT来: %s" %name
print(message)

#通过占位方式完成数字和字符串的拼接
name="czpodcast"
setup_year=2006
stock_price=19.99
message="%s,成立于；%d，股价是：%f" %(name,setup_year,stock_price)
print(message)

#精度控制
num1=11
num2=11.345
print("数字11宽度限制5，结果是：%5d" % num1)
print("数字11宽度限制1，结果是：%1d" % num1)#m不生效
print("数字11.345宽度限制7.小数精度2，结果是：%7.2f" % num2)
print("数字11.345不限制，小数精度2，结果是：%.2f" % num2)

#f”{占位}“

name="zhichuang"
set_up_year=2006
stock_price=19.99
#f:foemat
print(f"我是{name}，我成立于{set_up_year}年，我今日股价{stock_price}")

#运算符
print("my_package+my_package=",1+1)
print("2-my_package=",2-1)
print("3*3=",3*3)
print("4/2=",4/2)
print("11//2=",11//1) #整除
print("9%2=",9%2)#取余
print("9**2=",9**2)#求平方

#赋值运算符
num=1
num += 1 #num= num+my_package
print("num += my_package:",num)
num -=1
print("num -= my_package:",num)

num =9
num//=2
print("num//=2:",num)

#input

name=input("你是谁？")
print("我知道了，你是：%s"%name)

num=input("你的密码是")
#数据类型转换
num=int(num)
print("你的密码类型是：",type(num))

user_name=input("你是谁？")
user_type="sssvip"
print("你好%s"%user_name,"您是尊贵的：%s"%user_type)


