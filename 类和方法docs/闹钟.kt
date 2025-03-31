class Clock:
    id=None
    price=None

    def ring(self):
        import winsound
        winsound.Beep(2000,3000)

clock1=Clock()
clock1.id="003032"
clock1.price=19.9
print(f"{clock1.id},{clock1.price}")
clock1.ring()

clock2=Clock()
clock2.id="003032"
clock2.price=19.9
print(f"{clock2.id},{clock2.price}")
clock2.ring()
