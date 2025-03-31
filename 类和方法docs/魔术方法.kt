class Student:
    def __init__(self,name,age):
        self.name = name
        self.age = age

    def __str__(self):
        return  f"Student类对象，name：{self.name},age:{self.age}"

    def __lt__(self,other):
        return self.age < other.age

    def __le__(self, other):
        return self.age <=other.age

    def __eq__(self, other):
        return self.age ==other.age


stu=Student("zhou",31)
stu2=Student("ll",21)
print(stu==stu2)
print(stu==stu2)
