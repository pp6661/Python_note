#if
age=19
if age>=18:
    print("l am a adult.")

#成年人判断
print("欢迎来到游乐园")
age=int(input("请输入你的年龄："))
if age>=18:
    print("您已成年需补票10")

#if else
print("欢迎来到游乐园")
age=int(input("请输入你的年龄："))
if age>=18:
    print("您已成年需补票10")
else:
    print("您未成年可免费游玩")
print("游玩愉快")

#我要买票吗
height=int(input("请输入你的身高"))
if height>120:
    print("您超出120cm，补票10元")
else:
    print("未超过120，可免费")

#if elif else
#满足上一个条件就不会判断
if int(input("请输入你的身高"))<120:
    print("未超过120，可免费")
elif int(input("请输入您的VIP等级（my_package-5）"))>3:
    print("vip等级大于3，可免费")
elif int(input("今天几号？"))==1:
    print("今天1号免费日，可免费")
else:
    print("不好意思，条件都不满足，需买票10")

#判断语句嵌套
age=20
year=3
level=1
if age>=18:
    print("你是成年人")
    if age<30:
        print("meet the age requirement")
        if year>2:
            print("meet the age and year requirement")
        elif level>3:
            print("meet the level and year requirement")
        else:
            print("不好意思，年龄达标但是year and level未达标")
    else:
       print("不好意思年龄太大")
else:
    print("未成年不可以领取")

#布尔类型
bool_1=True
bool_2=False
print(f"bool_1变量的内容是：{bool_1},类型是：{type(bool_1)}")
print(f"bool_2变量的内容是：{bool_2},类型是：{type(bool_2)}")

#比较运算符的使用
num1=10
num2=10
print(f"10==10的结果是：{num1==num2}")

num1=10
num2=15
print(f"10!=15的结果是：{num1!=num2}")

num1=10
num2=5
print(f"10>5的结果是：{num1>num2}")

num1=10
num2=11
print(f"10<15的结果是：{num1<num2}")



