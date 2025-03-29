"""
和文件相关的类定义
"""
import json
from typing import List

from data_define import Record

# 先定义一个抽象类做顶层设计，确定哪些功能需要实现
class FileReader:

    def read_data(self) -> List[Record]:
        pass


class TextFileReader(FileReader):
    def __init__(self, path):
        self.path = path

        # 复写（实现抽象方法）父类

    def read_data(self) -> List[Record]:
        f = open(self.path, "r", encoding="UTF-8")

        record_list: List[Record] = []
        for line in f.readlines():
            line = line.strip()  # 消除\n
            data_list = line.split(",")
            record = Record(data_list[0], data_list[1], int(data_list[2]), data_list[3])
            record_list.append(record)

            f.close()
            return record_list


class JsonFileReader(FileReader):

    def __init__(self, path):
        self.path = path

    def read_data(self) -> List[Record]:
        f = open(self.path, "r", encoding="UTF-8")

        record_list: List[Record] = []
        for line in f.readlines():
            data_dict = json.loads(line)
            record = Record(data_dict["date"], data_dict["order_id"], int(data_dict["money"]), data_dict["province"])
            record_list.append(record)

        f.close()
        return record_list


if __name__ == '__main__':
    text_file_reader = TextFileReader("D:/资料/2011年1月销售数据.txt")
    json_file_reader = JsonFileReader("D:/资料/2011年2月销售数据JSON.txt")
    list1 = text_file_reader.read_data()
    list2 = json_file_reader.read_data()

    for l1 in list1:
        print(l1)

    for l2 in list2:
        print(l2)
