# Andriod开发实验四
@author: 068赖昌平
**自定义WebView验证隐式Intent的使用**
## 一、实验环境:
	Android Studio + Android 5.0
## 二、实验内容
### 1.获取URL地址并启动隐式Intent的调用
实验效果：![在这里插入图片描述](https://img-blog.csdnimg.cn/20200510102627896.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
#### 代码
首先需要画一个界面，所以首先编辑activity_main.xml

```javascript
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/textView"/>
    <EditText
        android:id="@+id/editText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textView"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="26dp"
        android:ems="10"
        android:hint="在此输入网址">
        <requestFocus />
    </EditText>

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/editText"
        android:layout_marginTop="14dp"
        android:layout_toRightOf="@+id/textView"
        android:layout_marginLeft="160dp"
        android:text="浏览该网页"/>
</RelativeLayout>
```
MainActivity.java

```java
public class MainActivity extends AppCompatActivity {

    private EditText urlEditText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = findViewById(R.id.button);//按钮
        this.urlEditText = findViewById(R.id.editText);//文本框
        button.setOnClickListener(new View.OnClickListener() {//点击事件
            @Override
            public void onClick(View v) {
                String url = urlEditText.getText().toString();//获取url
                Intent intent = new Intent(Intent.ACTION_VIEW);//为Intent设置Action
                Uri uri = Uri.parse(url);//转化为uri
                intent.setData(uri);//为Intent设置data属性
                startActivity(intent);
            }
        });
    }
}
```
#### 效果图
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020051010313457.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
选择谷歌浏览器
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200510103204354.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
### 2.自定义WebView来加载URL

#### 1.新建一个工程或Activity，活动命名为WebViewActivity
#### 2.编辑xml文件，添加一个WebView，代码

```javascript
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".WebViewActivity">
    <WebView
        android:id="@+id/webView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```
#### 3.WebViewActivity.java

```java
public class WebViewActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        //获得浏览器webView控件
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        //得到鼠标点击之后的intent
        Intent intent = getIntent();
        Uri uri = intent.getData();//获取data属性
        String urlString = null;
        try {
            urlString = new URL(uri.getScheme(), uri.getHost(), uri.getPath()).toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        webView.loadUrl(urlString);//加载
        //手机默认浏览器打开，为了通过WebView打开网页，设置
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(url.startsWith("http:") || url.startsWith("https:")){
                    view.loadUrl(url);
                    return false;
                }
                view.loadUrl(url);
                return true;
            }
        });
    }
```
#### 4.效果图
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200510104240264.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
可以看出，浏览器列表出现了刚刚自定义的浏览器
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200510104320328.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
## 结语
本次实验主要是探索一下Intent的使用，并且自定义了WebView进行隐式Intent的使用，所以也看了不少文档和博客进行学习，总的来说，Intent的内容蛮多的，也不容易，不过本次实验并不难做，也只是试试水，相信在今后的学习中能够不断进步。
总结一下遇到的问题吧
#### 一、Android 网页无法打开 net:ERR_UNKNOWN_URL_SCHEME
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200510105004646.png)
#### 我的解决办法：
将

```java
 webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
```
改成

```java
 webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(url.startsWith("http:") || url.startsWith("https:")){
                    view.loadUrl(url);
                    return false;
                }
                view.loadUrl(url);
                return true;
            }
        });
```
#### 二、Android使用WebView无法显示网页net:ERR_CLEARTEXT_NOT_PERMITTED
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200510105435381.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
### 我的解决方法：
在AndroidManifest.xml中添加一个属性

```java
android:usesCleartextTraffic="true"
```
#### 三、Android使用WebView无法显示网页net:ERR_ACCESS_DENIED
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200510105647690.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA5MDc5MQ==,size_16,color_FFFFFF,t_70)
#### 我的解决办法
我使用的是API29的模拟器，把它降为API28的模拟器就可以了
#### 参考文献(博客)
[1] https://blog.csdn.net/qq_36271550/article/details/98874574
[2] https://blog.csdn.net/dengdongqi/article/details/89679521
感谢以上几位同学，要不我可能交不上作业了。

