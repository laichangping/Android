# Andriod开发实验二

+ **Android布局实验**

## 一、实验环境:
	Android Studio + Android 5.0
## 二、实验内容
### 1.利用线性布局实现如下界面![](https://img-blog.csdnimg.cn/20200327203404785.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
这里可以看出，题目是要我们用线性布局生成一个4*4的表格是的textView，这个布局不难实现，只需要贴上四块LinearLayout，每块LinearLayout包含4个textView，横向布局，设置marginRight的值进行间隔就可以了，然后在最外面包含一个总的线性布局框，垂直布局，设置marginBottom值，就可以实现了
#### 代码：

```kotlin
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:orientation="horizontal"
        >


    <TextView
        android:layout_width="0dp"
        android:layout_height="50dp"
        android:layout_weight="1"
        android:text="One,One"
        android:background="#4DB38A"
        android:textColor="#333333"
        android:textSize="12dp"
        android:gravity="center"
        />
    <TextView
        android:layout_width="0dp"
        android:layout_height="50dp"
        android:layout_weight="1.3"
        android:layout_marginLeft="3dp"
        android:text="One,Two"
        android:background="#4DB38A"
        android:textColor="#333333"
        android:textSize="12dp"
        android:gravity="center"/>
    <TextView
        android:layout_width="0dp"
        android:layout_height="50dp"
        android:layout_marginLeft="3dp"
        android:layout_weight="1"
        android:text="One,Three"
        android:background="#4DB38A"
        android:textColor="#333333"
        android:textSize="12dp"
        android:gravity="center"/>
    <TextView
        android:layout_width="0dp"
        android:layout_height="50dp"
        android:layout_weight="1"
        android:layout_marginLeft="3dp"
        android:text="One,Four"
        android:background="#4DB38A"
        android:textColor="#333333"
        android:textSize="12dp"
        android:gravity="center"/>
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:paddingTop="3dp"
        android:orientation="horizontal">


        <TextView
            android:layout_width="0dp"
            android:layout_height="50dp"
            android:layout_weight="1"
            android:text="Two,One"
            android:background="#4DB38A"
            android:textColor="#333333"
            android:layout_gravity="center_horizontal"
            android:gravity="center"
            android:textSize="12dp"
            />
        <TextView
            android:layout_width="0dp"
            android:layout_height="50dp"
            android:layout_weight="1.3"
            android:layout_marginLeft="3dp"
            android:text="Two,Two"
            android:background="#4DB38A"
            android:textColor="#333333"
            android:textSize="12dp"
            android:gravity="center"/>
        <TextView
            android:layout_width="0dp"
            android:layout_height="50dp"
            android:layout_marginLeft="3dp"
            android:layout_weight="1"
            android:text="Two,Three"
            android:background="#4DB38A"
            android:textColor="#333333"
            android:textSize="12dp"
            android:gravity="center"/>
        <TextView
            android:layout_width="0dp"
            android:layout_height="50dp"
            android:layout_weight="1"
            android:layout_marginLeft="3dp"
            android:text="Two,Four"
            android:background="#4DB38A"
            android:textColor="#333333"
            android:textSize="12dp"
            android:gravity="center"/>
    </LinearLayout>


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:paddingTop="3dp"
        android:orientation="horizontal"
        >


        <TextView
            android:layout_width="0dp"
            android:layout_height="50dp"
            android:layout_weight="1"
            android:text="One, One"
            android:background="#4DB38A"
            android:textColor="#333333"
            android:gravity="center"
            android:textSize="12dp"

            />
        <TextView
            android:layout_width="0dp"
            android:layout_height="50dp"
            android:layout_weight="1"
            android:layout_marginLeft="3dp"
            android:text="Three, Two"
            android:background="#4DB38A"
            android:textColor="#333333"
            android:textSize="12dp"
            android:gravity="center"/>
        <TextView
            android:layout_width="0dp"
            android:layout_height="50dp"
            android:layout_marginLeft="3dp"
            android:layout_weight="1"
            android:text="Three,Three"
            android:background="#4DB38A"
            android:textColor="#333333"
            android:textSize="11dp"
            android:gravity="center"/>
        <TextView
            android:layout_width="0dp"
            android:layout_height="50dp"
            android:layout_weight="1"
            android:layout_marginLeft="3dp"
            android:text="Three,Four"
            android:background="#4DB38A"
            android:textColor="#333333"
            android:textSize="12dp"
            android:gravity="center"
            />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:paddingTop="3dp"
        android:layout_marginTop="3dp"
        android:orientation="horizontal"
        android:layout_weight="1"
        >

        <TextView
            android:layout_width="0dp"
            android:layout_height="50dp"
            android:layout_weight="1"
            android:text="Four, One"
            android:background="#4DB38A"
            android:textColor="#333333"
            android:gravity="center"
            android:textSize="12dp"
            />
        <TextView
            android:layout_width="0dp"
            android:layout_height="50dp"
            android:layout_weight="1"
            android:layout_marginLeft="3dp"
            android:text="Four,Two"
            android:background="#4DB38A"
            android:textColor="#333333"
            android:textSize="12dp"
            android:gravity="center"/>
        <TextView
            android:layout_width="0dp"
            android:layout_height="50dp"
            android:layout_marginLeft="3dp"
            android:layout_weight="1"
            android:text="Four,Three"
            android:background="#4DB38A"
            android:textColor="#333333"
            android:textSize="12dp"
            android:gravity="center"/>
        <TextView
            android:layout_width="0dp"
            android:layout_height="50dp"
            android:layout_weight="1"
            android:layout_marginLeft="3dp"
            android:text="Four,Four"
            android:background="#4DB38A"
            android:textColor="#333333"
            android:textSize="12sp"
            android:gravity="center"
            />
    </LinearLayout>
</LinearLayout>
```
#### 效果图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200327205055625.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)

### 2.利用ConstraintLayout实现如下界面
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200327205149507.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
估算每个方块的大小，并填上相应文字，慢慢调位置就好了
#### 代码：

```java
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Main2Activity"
    android:orientation="vertical">
    <TextView
        android:id="@+id/red_view"
        android:layout_width="65dp"
        android:layout_height="60dp"
        android:layout_marginLeft="3dp"
        android:background="@android:color/holo_red_light"
        android:text="RED"
        android:gravity="center"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="parent">

    </TextView>
    <TextView
        android:id="@+id/orange_view"
        android:layout_width="90dp"
        android:layout_height="60dp"
        android:layout_marginLeft="150dp"
        android:background="@android:color/holo_orange_light"
        android:text="ORANGE"
        android:gravity="center"
        app:layout_constraintLeft_toLeftOf="@+id/red_view"
        app:layout_constraintTop_toTopOf="parent">
    </TextView>

    <TextView
        android:id="@+id/yellow_view"
        android:layout_width="90dp"
        android:layout_height="60dp"
        android:layout_marginRight="3dp"
        android:background="#FFFF00"
        android:text="YELLOW"
        android:gravity="center"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent">
    </TextView>
    <TextView
        android:id="@+id/green_view"
        android:layout_width="90dp"
        android:layout_height="60dp"
        android:layout_marginLeft="60dp"
        android:layout_marginTop="25dp"
        android:background="#00FF00"
        android:text="GREEN"
        android:gravity="center"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/orange_view">
    </TextView>
    <TextView
        android:id="@+id/blue_view"
        android:layout_width="67dp"
        android:layout_height="60dp"
        android:layout_marginLeft="15dp"
        android:layout_marginTop="25dp"
        android:background="#0000FF"
        android:text="BLUE"
        android:gravity="center"
        app:layout_constraintLeft_toRightOf="@+id/green_view"
        app:layout_constraintTop_toBottomOf="@+id/orange_view">
    </TextView>
    <TextView
        android:id="@+id/INDIGO_view"
        android:layout_width="85dp"
        android:layout_height="60dp"
        android:layout_marginLeft="7dp"
        android:layout_marginTop="25dp"
        android:background="#484259"
        android:text="INDIGO"
        android:gravity="center"
        app:layout_constraintLeft_toRightOf="@+id/blue_view"
        app:layout_constraintTop_toBottomOf="@+id/orange_view">
    </TextView>
    <TextView
        android:id="@+id/violet_view"
        android:layout_width="fill_parent"
        android:layout_height="60dp"
        android:layout_marginLeft="5dp"
        android:layout_marginRight="5dp"
        android:layout_marginTop="15dp"
        android:background="#DB7093"
        android:text="VIOLET"
        android:gravity="center"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/green_view">
    </TextView>
</androidx.constraintlayout.widget.ConstraintLayout>
```
#### 效果图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200327205721576.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
### 3.利用表格布局实现如下界面
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200327205857534.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
#### 代码：

```java
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Main3Activity"
    android:stretchColumns="1">

    <TableRow>
        <TextView
            android:text="Open...."
            android:paddingLeft="10dp"/>
        <TextView
            android:text="Ctrl+O"
            android:gravity="right"
            android:paddingRight="10dp"/>
    </TableRow>
    <TableRow>
        <TextView
            android:text="Save...."
            android:paddingLeft="10dp"/>
        <TextView
            android:text="Ctrl+S"
            android:gravity="right"
            android:paddingRight="10dp"/>
    </TableRow>
    <TableRow>
        <TextView
            android:text="Save as...."
            android:paddingLeft="10dp"/>
        <TextView
            android:text="Ctrl+Shift+S"
            android:gravity="right"
            android:paddingRight="10dp"/>
    </TableRow>
    <TableRow>
        <TextView
            android:text="X Import...."
            android:paddingLeft="10dp"/>
    </TableRow>
    <TableRow>
        <TextView
            android:text="X Export...."
            android:paddingLeft="10dp"/>
        <TextView
            android:text="Ctrl+E"
            android:gravity="right"
            android:paddingRight="10dp"/>
    </TableRow>
    <TableRow>
        <TextView
            android:text="  Quit"
            android:paddingLeft="10dp"/>
    </TableRow>
</TableLayout>
```
#### 效果图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200327210108139.png)

## 三、结语
本次实验内容是我接触Android开发的首次尝试，内容不难，但是调整各个组件的位置让人抓狂，需要比较细心的进行调整，既是收获了Android开发的新知识，也回去重新巩固了一下html和css的相关内容，这次实验总体收获蛮大的，但第一次使用markdown语言比较生疏，写了一个晚上熟悉了一下，也算是不小的收获。

@author: 068赖昌平






