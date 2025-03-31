# 基础数据类型注解
# var_1:int=10
# var_2:str="itheima"
# var_3:bool=True

import json
import random

from typing import List, Tuple, Dict


# 类对象类型注解
class Student:
    pass


stu: Student = Student()
# 基础容器类型注解
# my_list:list=[1,2,3]
# my_tuple:tuple=(1,2,3)
# my_dict:dict={"it":666}

# 容器类型详细注解
my_list: List[int] = [1, 2, 3]
my_tuple: Tuple[int, str, bool] = (1, "itheima", True)
my_dict: Dict[str, int] = {"it": 666}

# 在注释中进行类型注解
var_1 = random.randint(1, 10)  # type:int
var_2 = json.loads('{"name":"zs"}')  # type:dict[str,str]
# 类型注解的限制
