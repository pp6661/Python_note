import json
from pyecharts.charts import Map
from pyecharts.options import TitleOpts,VisualMapOpts
f=open("D:/数分资料/资料/可视化案例数据/地图数据/疫情.txt","r",encoding="UTF-8")
data=f.read()
f.close()
data_dict=json.loads(data)
cities_data=data_dict["areaTree"][0]["children"][3]["children"]

data_list=[]
for city_data in cities_data:
    city_name=city_data["name"]+"市"
    city_confirm=city_data["total"]["confirm"]
    data_list.append((city_name,city_confirm))

data_list.append(("济源市",5))

map=Map()
map.add("河南省疫情分布",data_list,"河南")
map.set_global_opts(
    title_opts=TitleOpts(title="河南疫情地图",pos_left="center",pos_bottom="1%"),
    visualmap_opts=VisualMapOpts(
        is_show=True,
        is_piecewise=True,
        pieces=[
            {"min":1,"max":9,"lable":"1-99人","color":"CCFFFF"},
{"min": 10, "max": 99, "label": "10-99人", "color": "#FFFF99"},
{"min": 100, "max": 499, "label": "99-499人", "color": "#FF9966"},
{"min": 500, "max": 999, "label": "499-999人", "color": "#FF6666"},
{"min": 1000, "max": 9999, "label": "1000-9999人", "color": "#CC3333"},
{"min": 10000, "label": "10000以上", "color": "#990033"}
        ]
    )
)
#   8. 绘图
map.render()
