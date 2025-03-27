import json
#准备列表，列表中每个元素都是字典，转换为json
data=[{"name":"zs","age":11},{"name":"wq","age":13},{"name":"zz","age":16}]
json_str=json.dumps(data,ensure_ascii=False)
print(type(json_str))
print(json_str)

#准备字典，转换为json
d={"name":"joe","addr":"beijin"}
json_str=json.dumps(d,ensure_ascii=False)
print(type(json_str))
print(json_str)

#将json字符串转换为Python数据类型[{k:v,k:v},{k:v,k:v}]
s='[{"name":"zs","age":11},{"name":"wq","age":13},{"name":"zz","age":16}]'
l=json.loads(s)
print(type(l))
print(l)

#将json字符串转换为Python数据类型[{k:v,k:v}
s='{"name":"joe","addr":"beijin"}'
d=json.loads(s)
print(type(d))
print(d)