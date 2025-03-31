# 使用Union 需导包
from typing import Union, List

my_list: List[Union[int, str]] = [1, 2, "itheima", "itcast"]


def func(data: Union[int, str]) -> Union[int, str]:
    pass


func()
