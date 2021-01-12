# **CoolWeather：酷欧天气**

## **一、功能**

(1)罗列出全国所有的省市县
(2)查看全国任意城市天气信息
(3)自由切换查看其他城市天气信息
(4)手动更新功能，下拉刷新
用到了UI、网络、数据存储、服务等技术，几乎涵盖了这一学期的知识。
和风天气控制台，创建API接口，为了复制KEY。

## **二、项目结构**

db包的实体类中存放省市县的数据信息
gson包中定义GSON实体类用于解析数据
service包中长期在后台自动运行的定时更新服务
util包中有工具类：
(1)HttpUtil类负责与服务器进行交互
(2)Utility类负责解析和处理处理JSON格式的服务器数据
ChooseAreaFragment类用于遍历省市县数据碎片
MainActivity活动中加入了缓存数据的判断(就是之前请求过天气数据)
WeatherActivity活动能请求天气数据，并展示在界面上

## **三、布局设计**

(1)title.xml，头布局，居中城市名+居右更新时间
(2)now.xml，当前天气信息
(3)forecast.xml和forecast_item.xml，天气预报
(4)aqi.xml，空气质量信息，包括AQI跟PM2.5
(5)suggestion.xml，生活建议信息
(6)activity_weather.xml，将以上布局信息引入到这里
(7)choose_area.xml，ListView提供省市县给我们选择