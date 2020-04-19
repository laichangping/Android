# Android开发实验三
@author 赖昌平

 **AndroidUI组件**
## 一、实验环境:
	Android Studio + Android 5.0
## 二、实验内容
### 1.Android ListView的用法
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200419151337332.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
#### 代码
MainActivity.java
```java
package com.lab.labs;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MainActivity extends AppCompatActivity {
    private String[] names = new String[]
            {"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] imgIds = new int[]
            {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> lists = new ArrayList<>();
        for (int i = 0;i < names.length;i++){
            Map<String,Object> list = new HashMap<>();
            list.put("images",imgIds[i]);
            list.put("names",names[i]);
            lists.add(list);
        }

        ListView listView = findViewById(R.id.list_view01);

        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,
                lists, R.layout.simple_adapter,
                new String[] {"names","images"},
                new int[] {R.id.names,R.id.images});
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(MainActivity.this,names[position],Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}
```
simple_adapter.xml:

```css
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <TextView
        android:id="@+id/names"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:textSize="50dp"
         />

    <ImageView
        android:id="@+id/images"
        android:layout_width="70dp"
        android:layout_height="70dp"
        app:layout_constraintLeft_toRightOf="@id/names"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
         />

</androidx.constraintlayout.widget.ConstraintLayout>
```
activity_main.xml

```css
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical">

    <ListView
        android:id="@+id/list_view01"
        android:layout_height="wrap_content"
        android:layout_width="match_parent"
        tools:ignore="MissingConstraints" />

</androidx.constraintlayout.widget.ConstraintLayout>
```
#### 效果图
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200419153109320.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
### 2.创建自定义布局的AlertDialog
#### 代码
Main2Activity.java

```java
package com.lab.labs;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog alertDialog = new AlertDialog(Main2Activity.this);
        alertDialog.show();
    }
}
class AlertDialog extends Dialog {
    public AlertDialog(@NonNull Context context) {
        super(context);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        WindowManager windowManager = getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        display.getSize(size);
        p.width = size.x;
        getWindow().setAttributes(p);
    }
}
```
activity_main2.xml

```css
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <TextView
        android:id="@+id/title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="ANDROID APP"
        android:textSize="40dp"
        android:gravity="center"
        android:padding="10dp"
        android:textColor="@android:color/white"
        android:background="@android:color/holo_orange_light"
        app:layout_constraintTop_toTopOf="parent"
        />

    <EditText
        android:id="@+id/userName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint=" Username"
        app:layout_constraintTop_toBottomOf="@id/title"
        android:textSize="25dp"/>

    <EditText
        android:id="@+id/password"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint=" Password"
        android:textSize="25dp"
        android:inputType="textPassword"
        app:layout_constraintTop_toBottomOf="@id/userName" />

    <Button
        android:id="@+id/cancel_button"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="取消"
        android:textColor="#333333"
        android:textSize="25dp"
        android:background="@android:color/white"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toLeftOf="@id/confirm_button"
        app:layout_constraintTop_toBottomOf="@id/password" />

    <Button
        android:id="@+id/confirm_button"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="登录"
        android:textColor="#333333"
        android:textSize="25dp"
        android:background="@android:color/white"
        app:layout_constraintTop_toBottomOf="@id/password"
        app:layout_constraintLeft_toRightOf="@id/cancel_button"
        app:layout_constraintRight_toRightOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```
#### 效果图
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020041915420144.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
### 3.使用XML定义菜单
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200419154233852.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
#### 代码
Main3Activity.java

```java
package com.lab.labs;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private TextView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        test = findViewById(R.id.test);
        registerForContextMenu(test);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuinflater = getMenuInflater();
        menuinflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_size_1:
                test.setTextSize(11);
                return true;
            case R.id.menu_size_2:
                test.setTextSize(16);
                return true;
            case R.id.menu_size_3:
                test.setTextSize(21);
                return true;
            case R.id.menu_common:
                Toast.makeText(Main3Activity.this,"这是普通菜单项",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_color_red:
                test.setTextColor(Color.RED);
                return true;
            case R.id.menu_color_yellow:
                test.setTextColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


```
activity_main3.xml(主页面)

```java
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Main3Activity">

    <TextView
        android:id="@+id/test"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="用于测试的内容"
        android:textSize="16dp"
        tools:ignore="MissingConstraints" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
menu.xml

```css
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/menu_size"
        android:title="字体大小">
        <menu xmlns:android="http://schemas.android.com/apk/res/android">
            <item
                android:id="@+id/menu_size_1"
                android:title="小" />
            <item
                android:id="@+id/menu_size_2"
                android:title="中" />
            <item
                android:id="@+id/menu_size_3"
                android:title="大" />
        </menu>
    </item>
    <item
        android:id="@+id/menu_common"
        android:title="普通菜单项" />
    <item
        android:id="@+id/menu_color"
        android:title="字体颜色">
        <menu xmlns:android="http://schemas.android.com/apk/res/android">
            <item
                android:id="@+id/menu_color_red"
                android:title="红色" />
            <item
                android:id="@+id/menu_color_yellow"
                android:title="黄色" />
        </menu>
    </item>
</menu>
```
#### 效果图
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200419154635543.png)
更改字体大小和颜色
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200419154706547.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200419154727953.png)
### 4.创建上下文操作模式(ActionMode)的上下文菜单
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200419155124206.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
#### 效果图
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020041915493916.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
代码较多，可去github上看
## 结语
本次实验是熟悉Android UI 组件的应用，实验看起来简单，但实现起来蛮复杂的，花了不少时间，参考了不少百度以及其他人的代码才得以完成...虽然很菜但是相信通过不断努力可以有所进步。
