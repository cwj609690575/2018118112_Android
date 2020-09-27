# Homework 3

## 四种模式

### 1. standard（标准模式）

​	在活动默认的启动模式下（不进行显式指定的情况），每当启动一个新的活动，它就会在返回栈中入栈，并且处于栈顶的位置。对于使用该模式的活动，系统不会在乎这个活动在返回栈中是否已经存在，因此每次启动时都会创建该活动的一个新的实例。

​	启动程序，在FirstActivity界面连续点击两次按钮，从logcat的打印信息中可以看出，每点击一次按钮就会创建出一个新的FirstActivity实例，此时返回栈中也存在3个实例（包括启动程序创建的），因此需要连按3次Back键才能够退出程序。

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%203/PrintScreen/1.standard.JPG)

### 2. singleTop（单顶模式）

​	当活动的启动模式指定为singleTop，在启动活动时，如果发现返回栈的栈顶已经是该活动，则认为能够直接使用它，不会再创建新的活动实例。

​	启动程序，在FirstActivity界面下，无论点击多少次按钮都不会再有新的打印信息出现，因为FirstActivity已经处于返回栈的栈顶，每当想再启动一个FirstActivity时都会直接使用栈顶的活动，且按一次Back键就能退出程序。

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%203/PrintScreen/2.singleTop.JPG)

### 3. singleTask（单任务模式）

​	使用单顶模式可以很好地解决重复创建栈顶活动的问题，但是如果该活动没有处于栈顶位置，还是很可能创建多个活动实例的。当活动的启动模式指定为singleTask，每次启动该活动时系统首先会在返回栈中检查是否存在该活动的实例，若存在则直接使用该实例，并把存在于这个活动之上的所有活动统统出栈，如果不存在则创建一个新的活动实例。

​	启动程序，在SecondActivity下启动FirstActivity时，该模式会发现返回栈中已经存在一个FirstActivity的实例，并且在SecondActivity的下面，因此SecondActivity执行onDestroy()方法，从返回栈中出栈；而FirstActivity则执行onRestart()方法，重新成为栈顶活动。

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%203/PrintScreen/3.singleTask.JPG)

### 4. singleInstance（单实例模式）

​	不同于前三种启动模式，指定为singleInstance模式的活动会启用一个新的返回栈来管理这个活动。在这种模式下会有一个单独的返回栈来管理这个活动，不管是哪个应用程序来访问这个活动，都共用的同一个返回栈，解决了共享活动实例的问题。

​	启动程序，在FirstActivity界面点击按钮进入SecondActivity，再点击按钮进入到ThirdActivity。从logcat中的打印信息可以看出，SecondActivity的Task id与另外两个活动不同，说明它存放在了一个单独的返回栈中。

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%203/PrintScreen/4.singleInstance.JPG)