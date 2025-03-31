import json
from pyecharts.charts import Map
from pyecharts.options import TitleOpts,VisualMapOpts
#   1. 读取数据文件
f=open("D:/数分资料/资料/可视化案例数据/地图数据/疫情.txt","r",encoding="UTF-8")
data=f.read()
#   2. 关闭文件
f.close()
#   3. 取到各省数据
data_dict=json.loads(data)
province_data_list=data_dict["areaTree"][0]["children"]
#   4. 组装每个省份和确诊人数为元组，并将各省数据封装入列表内
data_list=[]
for province_data in province_data_list:
    province_name=province_data["name"]
    province_confirm=province_data["total"]["confirm"]
    data_list.append((province_name,province_confirm))


#   5. 创建地图对象
map=Map()

#   6. 添加数据
map.add("各省确诊人数",data_list,"china")
#   7. 设置全局配置，定制分段的视觉映射
map.set_global_opts(
    title_opts=TitleOpts(title="全国疫情地图",pos_left="center",pos_bottom="1%"),
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
