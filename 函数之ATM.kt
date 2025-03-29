money=5000000
name=None
name=input("请输入您的姓名")
def query(show_header):
    if show_header:
        print("__________查询余额----------")
    print(f"{name},余额为{money}")
def saving(num):
    global money
    money+=num
    print("__________存款----------")
    print(f"{name}，存款{num}元")

    query(False)
def get_money(num):
    global money
    money-=num
    print("__________取款----------")
    print(f"{name}，取款{num}元")

    query(False)

def main():
    print("__________主菜单----------")
    print(f"{name}，欢迎来到银行ATM,请选择操作")
    print("查询余额\t[输入1]")
    print("存款\t\t[输入2]")
    print("取款\t\t[输入3]")
    print("退出\t\t[输入4]")
    return input("您的选择")

while True:
    keyboard_input=main()
    if keyboard_input=="my_package":
        query(True)
        continue
    elif keyboard_input=="2":
        num=int(input("您想存多少？"))
        saving(num)
        continue
    elif keyboard_input=="3":
        num=int(input("您想取多少？"))
        get_money(num)
        continue
    else:
        print("退出啦")
        break

