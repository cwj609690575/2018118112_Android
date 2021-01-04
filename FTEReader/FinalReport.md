# **期末大作业： FTEReader 阅读器**

## **一、作业简介**

​		作为一个多年的小说阅读爱好者，在用了很多手机app看小说后也很难找到一个好用的、顺手的，要么会在你看得起劲的时候告诉你下一章需要收费，要么会在你翻页的时候弹出一条广告或者短视频，既影响心情，也影响看书的体验，令人十分抓狂。由此灵感，我运用了这学期的Android课程所学内容以及课外了解的知识，制作了一个基于追书神器API的小说阅读器——FTEReader。其优势有：

​		**(1)完全免费**

​		**(2)无广告移植**

​		**(3)热门榜单推荐**

​		**(4)可搜索大量在线书籍**

该应用Logo：<img src="https://github.com/cwj609690575/2018118112_Android/blob/homework/FTEReader/PrintScreen/Logo.jpg" width=100/>

## **二、程序界面**

### **1.主界面**

(1)书架界面（移除书籍）

<img src="https://github.com/cwj609690575/2018118112_Android/blob/homework/FTEReader/PrintScreen/%E4%B9%A6%E6%9E%B6%E7%95%8C%E9%9D%A2.jpg" width=300/> <img src="https://github.com/cwj609690575/2018118112_Android/blob/homework/FTEReader/PrintScreen/%E4%B9%A6%E6%9E%B6%E5%88%A0%E9%99%A4.jpg" width=300/>

(2)排行榜界面（最热榜）

<img src="https://github.com/cwj609690575/2018118112_Android/blob/homework/FTEReader/PrintScreen/%E6%8E%92%E8%A1%8C%E6%A6%9C%E7%95%8C%E9%9D%A2.jpg" width=300/> <img src="https://github.com/cwj609690575/2018118112_Android/blob/homework/FTEReader/PrintScreen/%E6%8E%92%E8%A1%8C%E6%A6%9C(2).jpg" width=300/>

(3)分类界面（科幻类）

<img src="https://github.com/cwj609690575/2018118112_Android/blob/homework/FTEReader/PrintScreen/%E5%88%86%E7%B1%BB%E7%95%8C%E9%9D%A2.jpg" width=300/> <img src="https://github.com/cwj609690575/2018118112_Android/blob/homework/FTEReader/PrintScreen/%E5%88%86%E7%B1%BB(2).jpg" width=300/>

(4)搜索界面（热搜＋搜索历史）

<img src="https://github.com/cwj609690575/2018118112_Android/blob/homework/FTEReader/PrintScreen/%E6%90%9C%E7%B4%A2%E7%95%8C%E9%9D%A2.jpg" width=300/>

### **2.书籍详情界面（同类推荐）**

<img src="https://github.com/cwj609690575/2018118112_Android/blob/homework/FTEReader/PrintScreen/%E4%B9%A6%E7%B1%8D%E8%AF%A6%E6%83%85.jpg" width=300/> <img src="https://github.com/cwj609690575/2018118112_Android/blob/homework/FTEReader/PrintScreen/%E5%90%8C%E7%B1%BB%E6%8E%A8%E8%8D%90.jpg" width=300/>

### **3.小说阅读界面**

(1)阅读界面

<img src="https://github.com/cwj609690575/2018118112_Android/blob/homework/FTEReader/PrintScreen/%E9%98%85%E8%AF%BB%E7%95%8C%E9%9D%A2.jpg" width=300/>

(2)夜间模式

<img src="https://github.com/cwj609690575/2018118112_Android/blob/homework/FTEReader/PrintScreen/%E5%A4%9C%E9%97%B4%E6%A8%A1%E5%BC%8F.jpg" width=300/>

(3)横屏模式

<img src="https://github.com/cwj609690575/2018118112_Android/blob/homework/FTEReader/PrintScreen/%E6%A8%AA%E5%B1%8F%E6%A8%A1%E5%BC%8F.jpg" width=300/>

(4)章节跳转

<img src="https://github.com/cwj609690575/2018118112_Android/blob/homework/FTEReader/PrintScreen/%E7%AB%A0%E8%8A%82%E8%B7%B3%E8%BD%AC.jpg" width=300/>

(5)字体调整

<img src="https://github.com/cwj609690575/2018118112_Android/blob/homework/FTEReader/PrintScreen/%E5%AD%97%E4%BD%93%E5%A4%A7%E5%B0%8F%E8%B0%83%E6%95%B4.jpg" width=300/>



## **三、功能说明**

### **1.主界面**

- 点击下方图标或左右滑动切换书架、排行榜、分类界面，点击右上角搜索图标进入搜索界面
- 从书架书架点击某一本书籍进入阅读界面
- 在排行榜界面点击左上角♂/♀图标切换男生/女生，点击某一个排行榜进入排行榜界面
- 在分类界面点击上方按钮切换男生/女生，点击某一个分类进入分类界面

### **2. 排行榜界面**

- 点击上方按钮切换周榜/月榜/总榜
- 点击某一本书籍进入书籍详情界面

### **3. 分类界面**

- 点击上方按钮切换热门/新书/好评/完结
- 点击某一本书籍进入书籍详情界面

### **4. 搜索界面**

- 在上方搜索框中输入书名，点击搜索按钮进行搜索
- 点击搜索结果中的书名跳转到书籍详情界面
- 点击“大家都在搜”/“搜索历史”中的书名直接跳转到书籍详情界面

### **5. 书籍详情界面**

- 点击左下角“加入书架”按钮可将当前书籍加入书架
- 点击右下角“免费阅读”按钮跳转到阅读界面
- 点击“同类推荐”中的书籍可跳转到该书籍的详情界面
- 点击“更多”按钮跳转到相关书籍界面

### **6. 阅读界面**

- 上下滑动进行阅读，左右滑动切换章节

- 点击屏幕中部，屏幕底部出现菜单：夜间/日间、横屏/竖屏、设置、目录

- 点击“夜间/日间”切换到夜间/日间模式

- 点击“横屏/竖屏”切换到横屏/竖屏模式

- 点击“设置”出现字体大小调整界面，点击“A-”减小字体大小，点击“A+”增大字体大小，点击屏幕其他任意地方返回

- 点击“目录”出现书籍目录，点击某个章节可跳转到该章节，点击屏幕其他任意地方返回

  

## **四、所运用到的技术**

1.书架和搜索信息数据库的创建管理

2.网络访问API查询书籍

3.RecyclerView、ListView显示书籍条目

4.RadioGroup制作导航栏

5.ViewPager+Fragment实现滑动切换页面

6.广播实现系统电量、时间的获取

7.RecyclerView的下拉刷新、上拉加载