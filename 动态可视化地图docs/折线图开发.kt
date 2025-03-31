# - 主题：演示可视化需求1：折线图开发
import json
from pyecharts.charts import Line
from pyecharts.options import TitleOpts, LabelOpts

#   1. 处理数据
f_us = open("D:\数分资料\资料\可视化案例数据\折线图数据\美国.txt", "r", encoding="UTF-8")
us_data = f_us.read()

f_jp = open("D:\数分资料\资料\可视化案例数据\折线图数据\日本.txt", "r", encoding="UTF-8")
jp_data = f_jp.read()

f_in = open("D:\数分资料\资料\可视化案例数据\折线图数据\印度.txt", "r", encoding="UTF-8")
in_data = f_in.read()
#   2. 去掉不合JSON规范的开头
us_data = us_data.replace("jsonp_1629344292311_69436(", "")
jp_data = jp_data.replace("jsonp_1629350871167_29498(", "")
in_data = in_data.replace("jsonp_1629350745930_63180(", "")

#   3. 去掉不合JSON规范的结尾
us_data = us_data[:-2]
jp_data = jp_data[:-2]
in_data = in_data[:-2]
#   4. JSON转Python字典
us_dict = json.loads(us_data)
jp_dict = json.loads(jp_data)
in_dict = json.loads(in_data)
#   5. 获取trend key
us_trend_data = us_dict['data'][0]['trend']
jp_trend_data = jp_dict['data'][0]['trend']
in_trend_data = in_dict['data'][0]['trend']
#   6. 获取日期数据，用于x轴，取2020年（到315下标结束）
us_x_data = us_trend_data['updateDate'][:314]
jp_x_data = jp_trend_data['updateDate'][:314]
in_x_data = in_trend_data['updateDate'][:314]
# print(x_data)
#   7. 获取确认数据，用于y轴，取2020年（到315下标结束）
us_y_data = us_trend_data['list'][0]['data'][:314]
jp_y_data = jp_trend_data['list'][0]['data'][:314]
in_y_data = in_trend_data['list'][0]['data'][:314]
#   8. 生成图表
line = Line()
line.add_xaxis(us_x_data)
line.add_yaxis("美国确诊人数", us_y_data, label_opts=LabelOpts(is_show=False))
line.add_yaxis("日本确诊人数", jp_y_data, label_opts=LabelOpts(is_show=False))
line.add_yaxis("印度确诊人数", in_y_data, label_opts=LabelOpts(is_show=False))

line.set_global_opts(
    title_opts=TitleOpts(title="2020年美日印三国确诊人数对比", pos_left="center", pos_bottom="1%")
)

line.render()
f_us.close()
f_jp.close()
f_in.close()
