# Homework 8: Android 多线程编程

## 一、多线程的基本用法

### 1.创建子程序的程序框架(3种方法)

#### （1）创建一个类继承自Thread，然后重写父类的run（）方法，在方法内编写耗时逻辑，代码如下：

```java
class MyThread extends Thread{
    @Override
    public void run(){
        //具体逻辑代码
    }
}
```

#### 启动线程只需要创建MyThread类的实例，然后调用它的start（）方法即可：

```Java
new MyThread().start();
```

#### （2）通过使用实现Runnable接口的方式来定义一个线程，代码如下：

```java
class MyThread implements Runnable{
    @Override
    public void run(){
        //具体逻辑代码
    }
}
```

#### 启动线程的方法如下：

```java
MyThread myThread = new MyThread();
new Thread(myThread).start();
```

#### （3）通过使用匿名类的方式创建线程：

```java
new Thread(new Runnable(){
    @Override
    public void run(){
        //具体逻辑代码
    }
}).start();
```

### 2.异步消息处理机制

### 		使用Android异步消息处理机制可以解决在子线程中更新UI的问题，一条信息经过一个流程的辗转调用以后，也就从子线程进入到了主线程，从不能更新UI到可以更新UI，这是异步消息处理的核心。Android中的异步消息处理主要由4个部分组成：Message、Handler、MessageQueue、Looper。

#### （1）Message：Message是在线程之间传递的消息，它可以携带少量的信息，用于在不同线程之间交换数据。

#### （2）Handler：Handler主要用于发送和处理消息，发送消息使用Handler的sendMessage（）方法，最后消息会传递到Handler的handleMessage（）方法中。

#### （3）MessageQueue:MessageQueue是一个消息队列，用于存放一个线程内所有通过Handler发送的消息。每个线程中只会有一个MessageQueue对象

#### （4）Looper：Looper负责管理MessageQueue，调用Looper的loop（）方法之后，就会进入到无限循环中，然后每当发现MessageQueue中存在Message消息就将它取出，并且传递到Handler的handleMessage（）方法中，每个线程中只有一个Looper对象。

#### 		由于Handler是在主线程中创建的，handleMessage（）方法也会在主线程中运行，这样，只要在子线程中调用sendMessage（）方法，就可以从子线程转到主线程中了。

### 3.多线程之间的数据交换(AsyncTask)

### 		使用AsyncTask可以更方便的从子线程切换到主线程。AsyncTask是一个抽象类，所以得先创建子类继承它，并且重写4个方法：

#### （1）onPreExecute（）：该方法会在后台任务开始执行之前调用，用于进行一些界面上的初始化操作。

#### （2）doInBackground（）：该方法中的所有代码都会在子线程中运行，所以应该在这里编写耗时逻辑代码，在这个方法中不可以进行UI操作，如果需要进行UI操作，可以调用publishProgress（）方法。

#### （3）onProgressUpdate（）：当调用了publishProgress（）方法之后，就会调用该方法，在该方法中可以进行UI操作。

#### （4）onPostExecute（）：当doInBackground（）方法执行完毕并且通过return语句进行返回时，就会调用onPostExecute（）方法，在该方法中可以进行一些任务的收尾工作。

## 二、服务的基本用法

### 1.启动和停止服务

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E5%90%AF%E5%8A%A8%E5%92%8C%E5%81%9C%E6%AD%A2%E6%9C%8D%E5%8A%A1(%E8%BF%90%E8%A1%8C%E7%95%8C%E9%9D%A2).JPG)

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E6%B4%BB%E5%8A%A8%E5%92%8C%E6%9C%8D%E5%8A%A1%E8%BF%9B%E8%A1%8C%E9%80%9A%E4%BF%A1(%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C).JPG)

##### 服务类MyService是继承自Service类的，说明这是一个服务。目前MyService类中空空如也，只有一个onBind()方法，它是Service中唯一的一个抽象方法，因此必须要在子类中实现。

##### 通常情况下，如果我们希望服务一旦启动就立刻去执行某个动作，就可以将逻辑写在onStartCommand()方法里。当服务销毁时，我们又应该在onDestroy()方法中去回收那些不再使用的资源。

##### 服务的启动与停止的方法主要借助Intent实现，onCreate()方法是在服务第一次创建的时候调用的，而onStartCommand()方法则在每次启动服务的时候都会调用。

### 2.活动和服务进行通信(子服务绑定并运行在异步任务)

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E6%B4%BB%E5%8A%A8%E5%92%8C%E6%9C%8D%E5%8A%A1%E8%BF%9B%E8%A1%8C%E9%80%9A%E4%BF%A1(%E8%BF%90%E8%A1%8C%E7%95%8C%E9%9D%A2).JPG)

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E6%B4%BB%E5%8A%A8%E5%92%8C%E6%9C%8D%E5%8A%A1%E8%BF%9B%E8%A1%8C%E9%80%9A%E4%BF%A1(%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C).JPG)

##### 对活动和服务进行绑定，使用继承自Service的MyService类中的onBind()方法，如果需要解除它们之间的绑定，调用一下unbindService()方法就可以了。

##### 任何一个服务在应用程序范围内都是通用的，因此MyService服务可以与任何一个活动进行绑定，并且在绑定完成后都可以获取到所定义的相同实例。

### 3.使用前台服务

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E5%89%8D%E5%8F%B0%E6%9C%8D%E5%8A%A1.JPG)

##### 服务基本都是在后台运行的，且服务的优先级比较低，当系统出现运行内存不足的情况时，有可能回收掉正在后台运行的服务，因此可以考虑使用前台服务。

##### 前台服务与普通服务的最大区别在于，它会有一个正在运行的图标在系统的状态栏显示，下拉状态栏后可以看到更详细的信息，类似于通知的效果。

### 4.使用 IntentService

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E4%BD%BF%E7%94%A8IntentService(%E8%BF%90%E8%A1%8C%E7%95%8C%E9%9D%A2).JPG)

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%207/PrintScreen/%E4%BD%BF%E7%94%A8IntentService(%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C).JPG)

##### 服务中的代码都是默认运行在主线程中的，如果直接在服务里去处理一些耗时的逻辑，就很容易出现应用无响应的情况。使用IntentService后运行程序，观察logcat中的打印日志，可以发现MyIntentService与MainActivity所在的线程 id 不一样，并且onDestroy()方法也得到执行，这说明MyIntentService在运行完毕后确实自动停止了。

