# Homework 4: Intent 的应用

## 1.显式、隐式 Intent

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/%E4%BD%BF%E7%94%A8Intent(First).JPG) ![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/%E4%BD%BF%E7%94%A8Intent(Second).JPG)

### (1) 显式 Intent

声明一个Intent实例，传入FirstActivity.this作为上下文、SecondActivity.class作为目标活动，这样子的意图非常明显，则称之为显式意图(Intent)。如果需要回到上一个活动，只需要点击Back键就可以销毁当前活动，从而返回到上一个活动。

### (2) 隐式 Intent

相对于显式Intent，隐式的则含蓄许多，它并不明确指出我们想要启动哪一个活动，而是指定一系列更抽象的action和category等信息，然后由系统分析这个隐含的意图并找出合适的活动来启动。

## 2.自定义 Intent

### (1) 百度

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/%E7%99%BE%E5%BA%A6.JPG)

首先指定了Intent的action是Intent.ACTION_VIEW，这是一个Android系统的内置动作，其常量值为android.intent.action.VIEW。然后通过Uri.parse()方法将一个网址的字符串解析为一个Uri对象，再调用Intent的setData()方法将这个Uri对象传递进去。

### (2) 拨号10086

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/10086.JPG)

除了http协议外，还可以指定很多其他的协议，比如geo表示显示地理位置、tel表示拨打电话。这里首先指定了Intent的action是Intent.ACTION_DIAL，然后在data部分指定了协议是tel，号码是10086。

## 3.向下一个活动传递数据

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/%E5%90%91%E4%B8%8B%E4%B8%80%E4%B8%AA%E6%B4%BB%E5%8A%A8%E4%BC%A0%E9%80%92%E6%95%B0%E6%8D%AE.JPG)

Intent也可以在启动活动的同时传递数据，其中提供了一系列的putExtra()方法传递了一个字符串，这个方法接收的第一个参数是键，用于后面从Intent中取值，第二个参数才是真正要传递的数据。

运行程序，在FirstActivity界面点击一下按钮会跳转到SecondActivity，再查看一下logcat打印信息，说明SecondActivity成功得到了从FirstActivity传递过来的数据

## 4.返回数据给上一个活动

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%204/PrintScreen/%E8%BF%94%E5%9B%9E%E6%95%B0%E6%8D%AE%E7%BB%99%E4%B8%8A%E4%B8%80%E4%B8%AA%E6%B4%BB%E5%8A%A8.JPG)

运行程序，在FirstActivity界面点击一下按钮会跳转到SecondActivity，然后在SecondActivity界面点击一下按钮会回到FirstActivity，再查看一下logcat打印信息，说明SecondActivity成功返回数据给FirstActivity了。