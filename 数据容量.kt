# 以数据容器角度，学习字符串相关操作。
my_str="itheima and itcast"
# 通过下标索引取值、
value=my_str[2]
value2=my_str[-16]
print(f"{value} and {value2}")

# `index`方法、
value=my_str.index("and")
print(f"{value} ")
# `replace`方法、
new_my_str=my_str.replace("it","程序")
print(f"{new_my_str} ")

# split`方法、
my_str="hello python itheima itcast"
my_str_list=my_str.split(" ")
print(f"{my_str_list} ")

# `strip`方法 。
my_str=" itheima and itcast "
new_my_str=my_str.strip()#不传入参数，去除首尾空格
print(f"{new_my_str} ")

my_str="12itheima and itcast21"
new_my_str=my_str.strip("12")
print(f"{new_my_str} ")

# 统计字符串中某字符串出现次数、
my_str="itheima and itcast"
count=my_str.count("it")
print(f"{count} ")
# 统计字符串的长度。
my_str="itheima and itcast"
num=len(my_str)
print(f"{num} ")

#分割字符串
my_str="itheima itcast boxuegu"
num=my_str.count("it")
print(f"{num}")
new_my_str=my_str.replace(" ","|")
print(f"{new_my_str}")
my_str_list=new_my_str.split("|")
print(f"{my_str_list}")

# 这是Python语言中列表的基本语法介绍，提取关键内容如下：
# - **字面量**：用 `[元素1, 元素2, 元素3, ...]` 的形式表示，元素之间用逗号隔开。
# - **定义变量**：`变量名称 = [元素1, 元素2, 元素3, ...]` ，将列表赋值给变量。
# - **定义空列表**：有两种方式，分别是 `变量名称 = []` 和 `变量名称 = list()` 。
# - **列表元素**：列表内每个数据叫元素，以 `[]` 作为列表标识 。

my_list=["itheima","itcast","python"]
print(my_list)
print(type(my_list))

my_list=["itheima",666,True]
print(my_list)
print(type(my_list))
#定义一个嵌套列表
my_list=[[1,2,3],[4,5,6]]
print(my_list)
print(type(my_list))

#下标索引
my_list=["tom","lily","rose"]
#列表下标索引，从前往后从0开始，每次加一，从后往前从-1开始，每次-my_package
print(my_list[0])
print(my_list[1])
print(my_list[2])

print(my_list[-1])
print(my_list[-2])
print(my_list[-3])

my_list=[[1,2,3],[4,5,6]]
print(my_list[1][1])

# 这是Python中列表的常见操作说明，关键内容提取如下：
mylist=["itcast","itheima","python"]
# my_package. **查找元素下标**：可查找某元素在列表内的下标索引，元素不存在会报错。
index=mylist.index("itheima")
print(f"{index}")
# 2. **修改元素值**：能修改特定下标索引的值。
mylist[0]="chuangzhi"
print(f"{mylist}")
# 3. **插入元素**：可在指定下标位置插入新元素。
mylist.insert(1,"best")
print(f"{mylist}")
# 4. **追加单个元素**：在列表尾部追加单个新元素。
mylist.append("heima programmer")
print(f"{mylist}")
# 5. **追加一批元素**：在列表尾部追加一批新元素。
mylist2=[1,2,3]
mylist.extend(mylist2)
print(f"{mylist}")
# 数据容量. **删除指定下标元素**：有两种方式，分别是 `del 列表[下标]` 和 `列表.pop(下标)`。
mylist=["itcast","itheima","python"]
del mylist[2]
print(f"{mylist}")

mylist=["itcast","itheima","python"]
element=mylist.pop(2)
print(f"{mylist}")
# 7. **删除首个匹配项**：删除某元素在列表中的第一个匹配项 。
mylist=["itcast","itheima","itcast","itheima","python"]
mylist.remove("itheima")
print(f"{mylist}")

# 8.清空列表：使用`列表名称.clear()`方法可以清空列表，
mylist.clear()
print(f"{mylist}")
# 9.统计全部元素数量** ：能够统计列表中全部的元素数量。
mylist=["itcast","itheima","itcast","itheima","python"]
count=mylist.count("itheima")
print(f"{count}")
# 10.统计全部元素数量** ：能够统计列表中全部的元素数量。
mylist=["itcast","itheima","itcast","itheima","python"]
count=len(mylist)
print(f"{count}")

#列表的功能练习
mylist=[21,25,21,23,22,20]
mylist.append(31)
print(f"{mylist}")
mylist2=[29,33,30]
mylist.extend(mylist2)
print(f"{mylist}")
mylist.remove(21)
print(f"{mylist}")
del mylist[-1]
print(f"{mylist}")

index=mylist.index(31)
print(f"{index}")



# 循环控制变量：使用下标索引控制，默认从0开始。
# 变量变化：每次循环下标索引变量加1。
# 循环条件：当下标索引变量小于列表的元素数量时进行循环。
def list_while_func():
    my_list=["chunagzhi","itheima","python"]
# 标记下标：可定义一个变量来标记列表的下标。
    index=0
    while index<len(my_list):
          elemnet=my_list[index]
          print(f"{elemnet}")
          index+=1
list_while_func()

# 语法格式**：`for 临时变量 in 数据容器:`
# 执行逻辑**：遍历`数据容器`中的元素，每次将元素赋值给`临时变量`，然后执行`对临时变量进行处理`的相关代码块。
def list_for_func():
    my_list=[1,2,3,4,5]
    for element in my_list:
        print(f"{element}")

list_for_func()

# 这是Python中关于元组（tuple）
# 定义元组
t1=(1,"hello",True)
t2=()
t3=tuple()
print(f"{type(t1)},内容{t1}")
print(f"{type(t2)},内容{t2}")
print(f"{type(t3)},内容{t3}")
# 定义单个元素的元组
t4=("hello",)
print(f"{type(t4)},内容{t4}")
# 元组的嵌套。
t5=((1,2,3,),(4,5,6))
print(f"{type(t5)},内容{t5}")
#下标索引取出内容
num=t5[1][2]
print(f"{num}")
# index查找方法
t6=("chunagzhi","heima","python")
index=t6.index("heima")
print(f"{index}")
# count统计方法、
t7=("chunagzhi","heima","heima","heima","python")
num=t7.count("heima")
print(f"{num}")
# len函数统计元组元素数量。
t8=("chunagzhi","heima","heima","heima","python")
num=len(t8)
print(f"{num}")
# while循环遍历
index=0
while index<len(t8):
    print(f"{t8[index]}")
    index +=1
# 和for循环遍历
for element in t8:
    print(f"2{element}")


# 语法格式
# 序列[起始下标:结束下标:步长]，它用于从序列中按规则取出元素形成新序列。

# - **起始下标**：表示从序列的哪个位置开始取元素，若留空则从序列开头开始。
# - **结束下标**：（不包含该位置元素）表示取元素到何处结束，若留空则截取到序列结尾。
# - **步长**：
#     - 步长为1时，逐个取元素。
#     - 步长为2时，每次跳过1个元素取。
#     - 步长为N时，每次跳过N - 1个元素取。
#     - 步长为负数时，反向取元素，此时起始下标和结束下标也要反向标记 。

# 对list进行切片，从1开始，4结束，步长1
list=[0,1,2,3,4,5,6]
result1=list[1:4]#步长为1，可省略
print(f"{result1}")

# 对tuple进行切片，从头开始，到最后结束，步长1
tuple=(0,1,2,3,4,5,6)
result2=list[:]
print(f"{result2}")

# 对str进行切片，从头开始，到最后结束，步长2
str=(0,1,2,3,4,5,6)
result3=list[::2]
print(f"{result3}")

# 对str进行切片，从头开始，到最后结束，步长-my_package
str2=(0,1,2,3,4,5,6)
result4=list[::-1]
print(f"{result4}")

# 对列表进行切片，从3开始，到1结束，步长-my_package
list2=[0,1,2,3,4,5,6]
result5=list[3:1:-1]
print(f"{result5}")

# 对元组进行切片，从头开始，到尾结束，步长-2
tuple3=(0,1,2,3,4,5,6)
result6=list[::-2]
print(f"{result6}")

# 演示数据容器集合的使用

 # 定义集合
my_set={"传智","黑马程序员","itheima","传智","黑马程序员","itheima","传智","黑马程序员","itheima"}
my_set_empty=set()
print(f"{my_set}")
print(f"{my_set_empty}")

# 添加新元素
my_set.add("python")
my_set.add("itheima")
print(f"{my_set}")

# 移除元素
my_set.remove("itheima")
print(f"{my_set}")

# 随机取出一个元素
my_set={"传智","黑马程序员","itheima"}
element=my_set.pop()
print(f"{my_set}")

# 清空集合
my_set.clear()
print(f"{my_set}")

# 取2个集合的差集
set1={1,2,3}
set2={1,5,6}
set3=set1.difference(set2)
print(f"{set3}")
print(f"{set1}")
print(f"{set2}")

#  消除2个集合的差集
set1={1,2,3}
set2={1,5,6}
set1.difference_update(set2)
print(f"{set1}")
print(f"{set2}")

# 2个集合合并为1个
set1={1,2,3}
set2={1,5,6}
set3=set1.union(set2)
print(f"{set3}")
print(f"{set1}")
print(f"{set2}")

# 统计集合元素数量
set1={1,2,3,4,5,1,2,3,4,5}
num=len(set1)
print(f"{num}")

#集合的遍历，不支持下标索引，不能用while循环
set1={1,2,3,4,5}
for element in set1:
    print(f"{element}")

#集合信息去重
my_list=["黑马程序员","传智","黑马程序员","传智","itheima","itcast","itheima","itcast","best"]
my_set=set()
for element in my_list:
    my_set.add(element)
print(f"{my_list}")
print(f"{my_set}")

# 演示数据容器字典的定义
# 定义字典{key:value,key:value,...,key:value}
my_dict={"pp":99,"lily":88,"rose":77}

# 定义空字典
my_dict2={}
my_dict3=dict()
print(f"{my_dict}")
print(f"{my_dict2}")
print(f"{my_dict3}")

# 定义重复Key的字典
my_dict={"pp":99,"pp":88,"rose":77}
print(f"{my_dict}")
# 从字典中基于Key获取Value
my_dict={"pp":99,"pp":88,"rose":77}
score=my_dict["pp"]
print(f"{score}")

# 定义嵌套字典
stu_score_dict={
    "pp":{
        "chinese":77,
        "english":89,
        "biology":88,
    },
    "lily":{
        "chinese":44,
        "english":48,
        "biology":88,
    },
    "rose":{
        "chinese":99,
        "english":48,
        "biology":88,
    }
}
print(f"{stu_score_dict}")
# 从嵌套字典中获取数据
score1=stu_score_dict["pp"]["chinese"]
print(f"{score1}")

# 演示字典的常用操作
my_dict={"pp":99,"lily":88,"rose":77}
# 新增元素
my_dict["joyce"]=66
print(f"{my_dict}")
# 更新元素
my_dict["pp"]=66
print(f"{my_dict}")
# 删除元素
score=my_dict.pop("pp")
print(f"{my_dict},{score}")
# 清空元素
my_dict.clear()
print(f"{my_dict}")
# 获取全部的key
my_dict={"pp":99,"lily":88,"rose":77}
keys=my_dict.keys()
print(f"{keys}")

# 遍历字典
for key in keys:
    print(f"{key}")
    print(f"{my_dict[key]}")

for key in my_dict:
    print(f"2{key}")
    print(f"2{my_dict[key]}")
# 统计字典内的元素数量
num=len(my_dict)
print(f"{num}")





