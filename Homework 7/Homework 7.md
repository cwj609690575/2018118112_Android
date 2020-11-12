# Homework 7: Android 多线程编程

## 一、多线程的基本用法

### 1.子线程中更新 UI 

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E5%9C%A8%E5%AD%90%E7%BA%BF%E7%A8%8B%E4%B8%AD%E6%9B%B4%E6%96%B0UI.JPG)

#### 与许多其他的GUI库一样，Android UI的线程也是不安全的。换句话说，如果想要更新应用程序中的UI元素，那么必须在主线程中进行，否则会出现异常。在子线程中更新UI，会导致程序崩溃。

### 2.异步消息处理

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E5%BC%82%E6%AD%A5%E6%B6%88%E6%81%AF%E5%A4%84%E7%90%86.JPG)

#### 使用Android异步消息处理机制可以解决在子线程中更新UI的问题，一条信息经过一个流程的辗转调用以后，也就从子线程进入到了主线程，从不能更新UI到可以更新UI，这是异步消息处理的核心。

## 二、服务的基本用法

### 1.启动和停止服务

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E5%90%AF%E5%8A%A8%E5%92%8C%E5%81%9C%E6%AD%A2%E6%9C%8D%E5%8A%A1(%E8%BF%90%E8%A1%8C%E7%95%8C%E9%9D%A2).JPG)

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E6%B4%BB%E5%8A%A8%E5%92%8C%E6%9C%8D%E5%8A%A1%E8%BF%9B%E8%A1%8C%E9%80%9A%E4%BF%A1(%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C).JPG)

服务类MyService是继承自Service类的，说明这是一个服务。目前MyService类中空空如也，只有一个onBind()方法，它是Service中唯一的一个抽象方法，因此必须要在子类中实现。

通常情况下，如果我们希望服务一旦启动就立刻去执行某个动作，就可以将逻辑写在onStartCommand()方法里。当服务销毁时，我们又应该在onDestroy()方法中去回收那些不再使用的资源。

服务的启动与停止的方法主要借助Intent实现，onCreate()方法是在服务第一次创建的时候调用的，而onStartCommand()方法则在每次启动服务的时候都会调用。

### 2.活动和服务进行通信

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E6%B4%BB%E5%8A%A8%E5%92%8C%E6%9C%8D%E5%8A%A1%E8%BF%9B%E8%A1%8C%E9%80%9A%E4%BF%A1(%E8%BF%90%E8%A1%8C%E7%95%8C%E9%9D%A2).JPG)

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E6%B4%BB%E5%8A%A8%E5%92%8C%E6%9C%8D%E5%8A%A1%E8%BF%9B%E8%A1%8C%E9%80%9A%E4%BF%A1(%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C).JPG)



### 3.使用前台服务

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E5%89%8D%E5%8F%B0%E6%9C%8D%E5%8A%A1.JPG)



### 4.使用 IntentService

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E4%BD%BF%E7%94%A8IntentService(%E8%BF%90%E8%A1%8C%E7%95%8C%E9%9D%A2).JPG)

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E4%BD%BF%E7%94%A8IntentService(%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C).JPG)



## 三、案例分析——下载软件

