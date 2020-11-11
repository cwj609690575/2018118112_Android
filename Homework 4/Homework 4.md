# Homework 4: UI 的简单控件

## 一、常用 UI 控件

### 1.TextView、Button、EditText、ImageView

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/SimpleWidget.JPG)

(1)对于TextView，指定了文字的大小、颜色和对齐方式；

(2)对于Button，禁用了所有英文字母自动进行大写转换，还在MainActivity中为其点击事件注册了一个监听器；

(3)对于EditText，指定了一段提示性的文本，只要有别的字该文本就消失；还指定了其文本框的最大行数为三行，当输入内容超过三行时文本会向上滚动且EditText不会再继续拉伸；

(4)对于ImageView，指定了点击Button按钮后，显示的图片变成设置好的另外一张图。

### 2.ProcessBar

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/ProcessBar1.JPG)

(1)指定了旋转的圆形进度条，表明程序正在加载数据，再点一下Button后进度条消失；

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/ProcessBar2.JPG)

(2)指定了水平进度条，每点一次Button就能够更新进度。

### 3.AlertDialog

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/AlertDialog.JPG)

点击Button后，在当前的页面弹出一个对话框，该对话框置顶于所有界面元素之上，且能够屏蔽掉其他控件的交互能力。

## 二、四种基本布局

### 1.线性布局（LinearLayout）

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/LinearLayout1.JPG)

(1)制定了排列方向为horizontal，因此只能指定垂直方向上的排列方向，将三个Button的对齐方式分别指定为top、center_vertical、bottom；

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/LinearLayout2.JPG)

(2)android:layout_weight属性能够使用比例的方式来指定控件的大小，将一个文本框和按钮放在一起，让Button的宽度自适应，剩下的位置留给EditText占满屏幕所有的剩余空间。

### 2.相对布局（RelativeLayout）

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/RelativeLayout.JPG)

通过相对定位的方式让控件出现在整个布局的任意位置，虽然属性特别多，但都有规律可循。

### 3.帧布局（FrameLayout）

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/FrameLayout.JPG)

这种布局没有方便的定位方式，所有控件都会默认摆放于布局的左上角，ImageView直接使用了@mipmap访问ic_launcher这张图，指定了TextView在布局中居左对齐，ImageView居右对齐，不这样设置属性的话图片将压在文字上面，会挡住文字的显示。

### 4.百分比布局（PercentFrameLayout）

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/PercentFrameLayout.JPG)

不需要使用wrap_content、match_parent等属性来指定控件大小，而是直接指定控件在布局中所占的百分比，这样就可以以任意比例分割布局。
