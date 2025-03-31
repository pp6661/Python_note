class Phone:
    IMEI=None
    producer="HM"

    def call_by_5g(self):
        print("5g call")

#定义子类，复写父类成员
class MyPhone(Phone):
    producer="ITHEIMA"

    def call_by_5g(self):
        print("updating!!")
        print(f"父类厂商{Phone.producer}")
        Phone.call_by_5g(self)

        print(f"父类厂商{super().producer}")
        super().call_by_5g()


phone=MyPhone()
phone.call_by_5g()
print(phone.producer)
