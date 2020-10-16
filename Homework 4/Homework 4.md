# Homework 4: UI 的简单控件

## 一、常用 UI 控件

### 1.TextView、Button、EditText、ImageView

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/SimpleWidget.JPG)

(1)对于TextView，指定了文字的大小、颜色和对齐方式；

(2)对于Button，禁用了所有英文字母自动进行大写转换，还在MainActivity中为其点击事件注册了一个监听器；

(3)对于EditText，指定了一段提示性的文本，只要有别的字该文本就消失了；还指定了其文本框的最大行数为三行，当输入内容超过三行时文本会向上滚动且EditText不会再继续拉伸；

(4)对于ImageView，指定了点击Button按钮后，显示的图片变成设置好的另外一张图。

### 2.ProcessBar



(1)指定了旋转的圆形进度条，表明程序正在加载数据，再点一下Button后进度条消失；



(2)指定了水平进度条，每点一次Button就能够更新进度。

### 3.AlertDialog



点击Button后，在当前的页面弹出一个对话框，该对话框置顶于所有界面元素之上，且能够屏蔽掉其他控件的交互能力。

## 二、四种基本布局

### 1.线性布局（LinearLayout）



### 2.相对布局（RelativeLayout）



### 3.帧布局（FrameLayout）



### 4.百分比布局（PercentFrameLayout）



## 三、ListView的用法

