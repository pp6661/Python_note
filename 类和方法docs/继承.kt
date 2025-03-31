class Phone:
    IMEI=None
    producer="HM"

    def call_by_4g(self):
        print("4g call")

class Phone2022(Phone):
    face_id="10001"

    def call_by_5g(self):
        print("new function:5g")

phone=Phone2022()
print(phone.producer)
phone.call_by_4g()
phone.call_by_5g()

class NFCReader:
    nfc_type="5 generation"
    producer="HM"

    def read_card(self):
        print("reading card")
    def write_card(self):
        print("writing card")

class RemoteControl:
    rc_type="remote control"

    def control(self):
        print("remote control opening")

class MyPhone(Phone,NFCReader,RemoteControl):
    pass

phone=MyPhone()
phone.call_by_4g()
phone.read_card()
phone.write_card()
phone.control()
