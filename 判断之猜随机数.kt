import random
num=random.randint(1,10)

guess_num=int(input("请输入你要猜的数字"))
if guess_num==num:
    print("恭喜，第一次就对了~")
else:
    if guess_num>num:
        print("bigger")
    else:
        print("smaller")

    guess_num= int(input("再次输入你要猜的数字"))
    if guess_num==num:
        print("yes")
    else:
        if guess_num>num:
            print("bigger")
        else:
            print("smaller")

    guess_num = int(input("再次输入你要猜的数字"))
    if guess_num == num:
        print("yes")
    else:
            print("三次机会用完了")