package com.lab.lab4;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
