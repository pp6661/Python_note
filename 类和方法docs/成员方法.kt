class Student:
    name=None

    def say_hi(self):
        print(f"hello,l am {self.name}")

    def say_hi2(self,msg):
        print(f"hello,l am {self.name},{msg}")

stu=Student()
stu.name="zhou"
stu.say_hi2("hhhhhhh")

stu2=Student()
stu2.name="lin"
stu2.say_hi2("666666")
