class Animal:
    def speak(self):
        pass


class Dog(Animal):
    def speak(self):
        print("汪汪汪")


class Cat(Animal):
    def speak(self):
        print("喵喵喵")


def make_noise(animal: Animal):
    animal.speak()


dog = Dog()
cat = Cat()

make_noise(dog)
make_noise(cat)


# 抽象类
class AC:
    def cool_wind(self):
        pass

    def hot_wind(self):
        pass

    def swing_l_r(self):
        pass


class midea_AC(AC):
    def cool_wind(self):
        print("midea cool")

    def hot_wind(self):
        print("midea hot")

    def swing_l_r(self):
        print("midea swing")


class green_AC(AC):
    def cool_wind(self):
        print("g cool")

    def hot_wind(self):
        print("g hot")

    def swing_l_r(self):
        print("g swing")


class xm_AC(AC):
    def cool_wind(self):
        print("x cool")

    def hot_wind(self):
        print("x hot")

    def swing_l_r(self):
        print("x swing")


def make_cool(ac: AC):
    ac.cool_wind()


midea_ac = midea_AC()
green_ac = green_AC()

make_cool(midea_ac)
make_cool(green_ac)
