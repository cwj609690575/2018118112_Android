# Homework 6: ListView & RecyclerView

## 一、最常用、最难用的控件 —— ListView

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%205/PrintScreen/ListView.JPG)

### 当程序中有大量的数据需要显示出来的时候，可以借助ListView控件来实现。

### 在这个布局中，定义了一个ImageView来显示水果的图片，还定义了一个TextView来显示水果的名称。

### 在MainActivity中，添加了一个initFruits() 方法（初始化所有水果的数据），在Fruit类的构造函数中将水果名字和对应图片ID传入，然后将创建好的对象添加到水果列表中。

## 二、更强大的滚动控件 —— RecyclerView

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%205/PrintScreen/RecyclerView1.JPG)

### (1)ListView的扩展性一般，只能实现数据纵向滚动的效果，由此，RecyclerView应运而生。它被认为是增强版的ListView，能实现和ListView几乎一模一样的效果，虽然在代码量上没有减少，但是逻辑更加清晰了，并且它还能实现ListView不能实现的效果（横向滚动、瀑布流布局）。

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%205/PrintScreen/RecyclerView2.JPG)

### (2)在MainActivity中加入一行代码，调用LinearLayoutManager的setOrientation()方法来设置布局的排列方向（默认为纵向），因此传入LinearLayoutManager.HORIZONTAL则是让布局横向排列。

![](https://github.com/cwj609690575/2018118112_Android/blob/homework/Homework%205/PrintScreen/RecyclerView3.JPG)

### (3)运用了getRandomLengthName() 这个方法，使用Random对象来创造一个1到20之间的随机数，再将参数中传入的字符重复随机遍。在initFruits() 方法中每个水果的名字都改成调用getRandomLengthName() 来完成，这样就能保证水果的名字长短不一，就能够形成瀑布流布局。此外，还对其设置了点击事件，不同于ListView的是，RecyclerView并没有提供类似setOnItemClickListener() 这样注册监听器的方法，而是需要我们自己具体的View去注册点击事件，相对来说会比较复杂一些。