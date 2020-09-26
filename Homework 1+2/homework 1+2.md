# **Homework 1**

## **一、HelloWorld显示**

## **二、生命周期的回调函数在不同条件下的触发条件和运行机制**

1.运行该程序，MainActivity在第一次被创建时依次执行onCreate()、onStart()、onResume()方法

2.点击“打开普通的活动”按钮，在启动NormalActivity时会将MainActivity完全遮挡，因此onPause()和onStop()方法都会执行

3.按下手机的Back键返回MainActivity，依次执行onStart()和onResume()方法，因为MainActivity在上一步骤已进入了停止状态，但onCreate()方法不会执行（MainActivity活动没有被销毁）

4.点击“打开对话框式的活动”按钮，在启动DialogActivity时并没有将MainActivity完全遮挡，因此只有onPause()方法执行（MainActivity只进入了暂停状态，并未进入停止状态）

5.再按下手机的Back键返回MainActivity，只有onResume()方法执行

6.最后，在MainActivity按下Back键退出程序，依次执行onPause()、onStop()、onDestroy()方法，将MainActivity销毁
