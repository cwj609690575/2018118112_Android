

[toc]

## 1.设置ToolBar

### 1.1.隐藏ActionBar

由下图中的android:theme="@style/AppTheme"可知，安卓的主题是由value下的style文件中的AppTheme输定定义的。

![1606485456571](实验报告12.assets/1606485456571.png)

修改主题为NoActionBar，隐藏ActionBar如下：

![1606485548446](实验报告12.assets/1606485548446.png)

### 1.2.设置activity_main的布局

background设置的是背景色

theme设置的是让ToolBar单独使用深色主题

popupThem设置的是设置弹出的菜单项为浅色主题

![1606485872102](实验报告12.assets/1606485872102.png)

### 1.3.实例化ToolBar

注意，这里导入的ToolBar是

```
import androidx.appcompat.widget.Toolbar;
```

![1606486265163](实验报告12.assets/1606486265163.png)

### 1.4.设置ToolBar的名称

android:label用来设置应用显示的名称

![1606486459040](实验报告12.assets/1606486459040.png)

### 1.5.添加Action按钮

item标签用于定义action按钮，app:showAsAction用来指定按钮的位置，可用的值有：always(永远显示在ToolBar，除非屏幕空间不够)、ifRoom(屏幕空间足够的情况下显示在ToolBar，不够的话显示在菜单)、never(永远显示在菜单中)。

注意：ToolBar的action按钮只会显示图标，而菜单中的action按钮只会显示文字。

![1606488773599](实验报告12.assets/1606488773599.png)

### 1.6.加载toolbar.xml

这里有两个方法，第一个方法是自己写的，getMenuInflater().inflate()方法用来加载toolbar.xml文件，第二个则是处理每一个action按钮的点击事件。

![1606489740286](实验报告12.assets/1606489740286.png)

## 2.设置滑动菜单

### 2.1.添加依赖库

下面两行是我添加的依赖库，第一个是Material 库、第二个是CircleImageView。

```
implementation 'com.google.android.material:material:1.0.0'
implementation 'de.hdodenhof:circleimageview:3.0.1'
```

![1606490326299](实验报告12.assets/1606490326299.png)

### 2.2.设置布局

设置滑动菜单的下方为五个action按钮，checkableBehavior="single"指定的是菜单项只能单选。

![1606490806369](实验报告12.assets/1606490806369.png)

设置滑动菜单上方布局为RelativeLayout，控件为一个圆形的图标和两个文本显示框。

![1606491271503](实验报告12.assets/1606491271503.png)

![1606491282378](实验报告12.assets/1606491282378.png)

### 2.3.将滑动菜单添加到主界面

这里对之前的布局略有修改，主要还是把FrameLayout放到DrawerLayout中，然后在其下方又加了一个滑动菜单，滑动菜单设置上方的布局和下方的布局，大致如此。

![1606491563006](实验报告12.assets/1606491563006.png)

![1606491575689](实验报告12.assets/1606491575689.png)

### 2.4.处理滑动菜单的菜单项点击事件

处理HomeAsUp按钮的点击事件，点击后显示滑动菜单。

![1606492514190](实验报告12.assets/1606492514190.png)

getSupportAcionBar()用来得到ToolBar（本题）的实例，setDisplayHomeAsUpEnable()让导航按钮显示出来，setHomeAsUpIndicator()设置导航按钮图标。

setCheckItem()方法将Call设为默认选中状态

setNavigationItemSelectedListener()方法设置被选中的菜单项的事件监听器，当用户点击后，会调用方法onNavigationItemSelected()方法。

closeDrawers()方法将滑动菜单关闭

![1606492271607](实验报告12.assets/1606492271607.png)

## 3.添加悬浮按钮和可交互提示

### 3.1.添加FloatingActionButton空间

首先，在主界面布局的FrameLayout中添加图中的<com.google.android.material.floatinggactionbutton.FloatingActionButton>，用于添加一个FloatingActionButton，并设置其属性，将其放在主界面的右下角，设置其图标为value/drawable下的图片ic_done，app:elevation可设置其悬浮高度，高度值越大，投影范围越大，但投影效果越淡。

![1606723519721](实验报告12.assets/1606723519721.png)

### 3.2实例化FloatingActionButton并设置点击事件处理

这里有几个需要注意的点，首先，他的点击事件是View.onClickListener。然后Toast.makeText不再是只能用this，而得用MainActivity.this，否则会报错。

还有就是介绍一下这个Snackbar，他作为一个更强大的提示工具，可以通过添加setAction来添加选项，点击选项后可以执行其他相应的操作。这里模拟的是误删了某个东西后，点击Undo可以实现数据重载。

![1606724882457](实验报告12.assets/1606724882457.png)

### 3.3.CoordinatorLayout

上面的代码运行后，其实会发现一个问题，就是Snackbar提示将悬浮按钮给遮挡住了，虽然时间不长，但是细节决定成败，因此，我们用CoordinatorLayout来解决这个问题。

其实CoordinatorLayout可以说是一个加强版的FrameLayout，就是比FrameLayout多拥有一些额外的Material功能。

这个比较简单，只要把原本主界面的FrameLayout改为以下语句即可，如果是自动补齐的话，他的尾部也会自动更新（Android Studio特有，其他不晓得）。

![1606725470354](实验报告12.assets/1606725470354.png)

![1606725549411](实验报告12.assets/1606725549411.png)

## 4.卡片式布局

### 4.1.添加依赖库

这里第一个是RecyclerView的库，第二个是Glide库，Glide是一个超级强大的开源图片加载库。它可以加载本地图片、网络图片、GIF图片甚至本地视频。

![1606726009149](实验报告12.assets/1606726009149.png)

### 4.2.添加RecyclerView布局

在主界面的CoordinatorLayout中添加RecyclerView布局。这里我们设置了其的布局宽度和高度都match_parent，让它能够布满全局。

![1606726242890](实验报告12.assets/1606726242890.png)

接着我们定义一个Fruit类

![1606726545231](实验报告12.assets/1606726545231.png)

然后，创建一个属于RecyclerView的子项的自定义布局，在layout目录下创建fruit_item.xml

这里，我们采用MaterialCardView作为子项的最外层布局，使得每个RecyclerView的元素都在卡片当中。为了让后边RecyclerView的定位容易些，我们又嵌套了一个LinearLayout，并把每个子项的内容放在其中。内容也比较简单，就是一个图片和一个文本显示框。

内容中唯一陌生的可能就是ImageView中的scaleTyep了，他可以指定图片缩放模式，这里的centerCrop是让图片保持原有比例填满ImageView。并将超出屏幕的部分裁剪掉。

![1606727026919](实验报告12.assets/1606727026919.png)

![1606727039792](实验报告12.assets/1606727039792.png)

创建RecyclerView的适配器类FruitAdapter

![1606728595579](实验报告12.assets/1606728595579.png)

这里唯一需要注意的是，这个地方用的加载图片的方式换成了Glide。Glide的用法也比较简单，首先用Glide.with()传入一个Context、Activity或Fragment参数，然后调用load()加载图片，该图片可以是一个URL地址，也可以是一个本地路径，或者是一个资源id。最后调用into()方法把图片设置到具体某一个ImageView中即可。

![1606728619226](实验报告12.assets/1606728619226.png)

定义一个水果的数组，存放Fruit实例。

![1606745545858](实验报告12.assets/1606745545858.png)

initFruit() 方法清空fruitList中的数据，然后用一个随机函数来使得每次打开程序看到的水果数据都是不同的。

![1606745774117](实验报告12.assets/1606745774117.png)

在onCreate()方法调用initFruit后，就是一些RecyclerView的常规操作，值得注意的是，这里用的针对RecyclerView的布局方式是GridLayout，卡片布局，其中第二个参数是列数，即每一行显示多少个item子项。

![1606745974354](实验报告12.assets/1606745974354.png)

### 4.3.AppBarLayout

以上的代码运行的程序会出现RecyclerView把ToolBar遮挡住的现象，因此，这里我们就需要引入一个AppBarLayout布局，其实就是一个垂直方向的LinearLayout，他在内部做了很多滚动事件的封装，并应用了一些MaterialDesign的设计理念。

解决遮挡问题很简单，只需要两步，首先，把ToolBar内嵌到AppBarLayout中，如下：

![1606746508999](实验报告12.assets/1606746508999.png)

然后，第二步是给RecyclerView指定一个布局行为，如下：

其实就是加一句app:layout_behavior="..."

![1606746926470](实验报告12.assets/1606746926470.png)

实现RecyclerView向上滚动时，ToolBar隐藏，RecyclerView向下滚动时，ToolBar重新显示，当ToolBar未完全显示或隐藏时，会根据滚动距离自动选择隐藏或者显示，其实只需要加一个属性app:layout_scrollFlags="..."，这里需要注意的是|左右的字符不可以有空格，否则会报错。

![1606746915955](实验报告12.assets/1606746915955.png)

## 5.下拉刷新

### 5.1.SwipeRefreshLayout

在RecyclerView外层嵌一层SwipeRefreshLayout，这样RecyclerView就有下拉刷新功能了。

![1606747243037](实验报告12.assets/1606747243037.png)

接下来，我们还得在活动中对其进行真正的代码实现才能有相应的功能实现，如下：

首先在onCreate()方法中添加：

setColorSchemeResources()方法用于设置下拉刷新进度条颜色

setOnRefreshListener()方法就是设置一个监听器，当用户下拉时，刷新动作该如何实现

![1606747637585](实验报告12.assets/1606747637585.png)

下面这个方法也比较简单，需要提的是runOnUiThread是跑回主线程（界面线程）运行界面的东西，这里就是简单的实现一下对水果的重新排布这样子。notifyDataSetChanged()用来通知数据发生了变化，SwipeRefreshLayout用于表示刷新事件结束，隐藏刷新进度条。

![1606747747682](实验报告12.assets/1606747747682.png)

## 6.可折叠式标题栏

### 6.1.CollapsingToolbarLayout布局

CollapsingToolbarLayout是一个作用于Toolbar基础上的布局，由Material库提供，可以让Toolbar的效果变得丰富。不过，CollapsingToolbarLayout不能独立存在，只能作为AppBarLayout的子布局，而AppBarLayout必须是CoordinatorLayout的子布局，因此，下面，我们创建一个新的活动FruitActivity和他的布局文件activity_fruit.xml。

并在布局文件放下CoordinatorLayout布局和CoordinatorLayout的子布局AppBarLayout布局，再放入AppBarLayout的子布局CollaspingToolbarLayout布局。

从代码可以清晰的看到CoordinatorLayout内嵌了AppBarLayout，AppBarLayout又内嵌了CollapsingToolbarLayout，这里的几个属性上面其实都遇到过了，就不详细讲解了。

![1607005095747](实验报告12.assets/1607005095747.png)

在CollapsingToolbarLayout中再定义一个ImageView和Toolbar，即该高级版的标题栏将是由普通得到标题栏加上图片组合而成的。这里需要解释的是，app:layout_collapseMode属性主要是用来指定当前控件再CollapsingToolbarLayout折叠过程中的折叠模式，pin表示再折叠的过程中位置始终保持不变，ImageView指定成parallax表示在折叠过程中产生一定的错位偏移，这种模式的视觉效果会非常好。

![1607005425968](实验报告12.assets/1607005425968.png)

在AppBarLayout同级再嵌套一个NestedScrollView。它允许使用滚动的方式来查看屏幕以外的数据，而NestedScrollView在此基础上还添加了嵌套响应滚动事件的功能。

在NestedScrollView中内嵌一个LinearLayout布局，LinearLayout中有一个文本框用来显示内容。

![1607007469823](实验报告12.assets/1607007469823.png)

![1607007482190](实验报告12.assets/1607007482190.png)

添加一个ActionButton，因为比较简单，这里不多做介绍。

![1607007781070](实验报告12.assets/1607007781070.png)

### 6.2.CollapsingToolbarLayout活动实现

这里首先要注意的是，这两个静态变量要是public形式的，因为在FruitAdapter中会需要用到。

![1607039738107](实验报告12.assets/1607039738107.png)

generateFruitContent()方法比较简单，就是生成500次该水果的名称，作为模拟的水果点击后的显示内容。

onOptionsItemSelected()方法用来处理HomeAsUp的点击事件，当点击这个按钮时，就调用finish()方法关闭当前活动，返回上一级活动。

![1607039721945](实验报告12.assets/1607039721945.png)

这个算是重头戏了，首先用intent获取水果的姓名和图片ID号，通过findViewById实例化，接着使用Toolbar的标准用法，将他作为ActionBar显示，并启动HomeAsUp按钮。

接下来，调用CollapsingToolbarLayout设置标题，并把图片加载进界面，并放到布局中的fruitImageView上，接着就是调用刚才提到的生成文本信息的函数generateFruitContent()，并将他设置到了TextView上面。

![1607039707402](实验报告12.assets/1607039707402.png)

内容的东西都看完了，接下来，我们看适配器怎么工作。下面给出FruitAdapter代码：

这里其实很简单，就是给每个卡片（水果）设置一个监听器，当有水果被点击的时候，getAdapterPositon()获取被点击的位置，然后fruitList再getposition()得知是哪个水果被点击了，接下来通过意图，把该水果的名字和ImageId通过intent发送到FruitActivity.FRUIT_NAME和FruitActivity.FRUIT_IMAGE_ID中，并启动这个意图，实现发送，从而调用FruitActivity这个互动，打开一个新的界面。

![1607040300507](实验报告12.assets/1607040300507.png)

### 6.3.充分利用系统状态栏空间

这个比较简单，就是给ImageView还有他布局结构中所有的父布局都设置上属性android:fitsSystemWindows=“true”，该属性作用是让ImageView填充满窗口。代码如下：

![1607040814922](实验报告12.assets/1607040814922.png)

![1607040840443](实验报告12.assets/1607040840443.png)

接着，在style中添加本截图的最后一个style及其item，并在Manifest文件中调用即可。

![1607041128655](实验报告12.assets/1607041128655.png)

![1607041272462](实验报告12.assets/1607041272462.png)

## 7.程序运行结果

程序初始界面如下：

![1607041620354](实验报告12.assets/1607041620354.png)

点击左上角的三个横线，弹出滑动菜单：

![1607041668113](实验报告12.assets/1607041668113.png)

点击Friens，先返回主界面，再打开滑动菜单会发现Friends变量，其他的变暗，显示如下：

![1607041688258](实验报告12.assets/1607041688258.png)

![1607041726887](实验报告12.assets/1607041726887.png)

点击ToolBar右上角的三个按钮则会用Toast显示他被点击了，其中，setting有点不同，他隐藏在三个小点的里面，如下：

![1607041771873](实验报告12.assets/1607041771873.png)

![1607041784526](实验报告12.assets/1607041784526.png)

![1607041794754](实验报告12.assets/1607041794754.png)

![1607041803568](实验报告12.assets/1607041803568.png)

点击右下角的悬浮按钮，如下：

我们可以点击UNDO选项，这里模拟的是点击后删除数据，然后点击UNDO按钮就把数据重载进来的现象。

![1607041852880](实验报告12.assets/1607041852880.png)



![1607041874751](实验报告12.assets/1607041874751.png)

我们还可以下拉刷新，刷新前后图片会不同，对比如下：

![1607041944765](实验报告12.assets/1607041944765.png)

![1607041973993](实验报告12.assets/1607041973993.png)

接着，我们点击随便一个图片，进入内部如下：

![1607042003184](实验报告12.assets/1607042003184.png)

这里，我们如果往下拉的话，图片还会智能的自己隐藏起来，如下：

![1607042033311](实验报告12.assets/1607042033311.png)

点击左上角的回退按钮，则会返回上一级界面，如下：

![1607042059672](实验报告12.assets/1607042059672.png)

