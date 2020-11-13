# Homework 7:广播机制

## 一、广播机制

#### 	注册广播的方式一般有两种，分为：在代码中注册(动态注册)和在AndroidManifest.xml中注册(静态注册)。

### 1.动态注册监听

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%206/PrintScreen/%E5%8A%A8%E6%80%81%E6%B3%A8%E5%86%8C%E7%9B%91%E5%90%AC(%E6%97%A0%E7%BD%91%E7%BB%9C%E5%8F%AF%E7%94%A8).JPG) ![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%206/PrintScreen/%E5%8A%A8%E6%80%81%E6%B3%A8%E5%86%8C%E7%9B%91%E5%90%AC(%E7%BD%91%E7%BB%9C%E5%8F%AF%E7%94%A8).JPG)

#### 		运行程序，按下Home键回到主界面(不能按Back键，否则onDestroy()方法会执行)，打开设置→流量使用情况，尝试开关 “移动数据网络” 按钮来启动和禁用网络，会有Toast提醒网络是否可用。

### 2.静态注册实现开机启动

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%206/PrintScreen/%E9%9D%99%E6%80%81%E6%B3%A8%E5%86%8C%E5%AE%9E%E7%8E%B0%E5%BC%80%E6%9C%BA%E5%B9%BF%E6%92%AD.JPG)

#### 		动态注册在灵活性优势较大，但是一定要在程序启动之后才能接收到广播，而静态注册的方式可以让模拟器在重新启动完成后收到开机广播。

### 3.发送自定义广播

#### (1)发送标准广播

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%206/PrintScreen/%E8%87%AA%E5%AE%9A%E4%B9%89%E5%B9%BF%E6%92%AD(%E6%A0%87%E5%87%86%E5%B9%BF%E6%92%AD).JPG)

#### 		在Button按钮的点击事件中加入了发送自定义广播的逻辑。首先构建了Intent对象并将要发送的广播的值传入，然后调用Context的sendBroadcast()方法将广播发送出去。

#### (2)发送标准广播至两个程序

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%206/PrintScreen/%E5%8F%91%E9%80%81%E6%A0%87%E5%87%86%E5%B9%BF%E6%92%AD(1).JPG) ![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%206/PrintScreen/%E5%8F%91%E9%80%81%E6%A0%87%E5%87%86%E5%B9%BF%E6%92%AD(2).JPG)

#### 		广播是一种可以跨进程的通信方式，因此在应用程序内发出的广播，其他的应用程序也是可以收到的。在这之前程序发出的都是标准广播。

### (3)发送有序广播

#### 	在onReceive()方法中调用abortBroadcast()方法，就能够将这条广播截断，在后面的接收器无法再收到这条广播，只会有一条Toast信息弹出。

### (4)使用本地广播

#### 	![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%206/PrintScreen/%E4%BD%BF%E7%94%A8%E6%9C%AC%E5%9C%B0%E5%B9%BF%E6%92%AD.JPG)

#### 为了解决广播的安全性问题，Android引入了一套本地广播机制，这使得该广播只能够在内部应用程序中进行传递，而且广播接收器也只能够接收来自本应用程序发出的广播。本地广播是无法通过静态注册的方式来接收的。

#### 三点优势：

①可以明确知道正在发送的广播不会离开我们的程序，确保了机密数据不会泄密；

②其他程序无法将广播发送到我们程序内部，因此不需要担心会有安全漏洞的隐患；

③发送本地广播比发送系统全局广播将更加高效。

## 二、案例分析——实现强制下线