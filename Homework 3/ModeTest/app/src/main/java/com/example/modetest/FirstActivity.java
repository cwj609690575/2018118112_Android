package com.example.modetest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //standard
        Log.d("FirstActivity", this.toString());
        //singleInstance
        Log.d("FirstActivity", "Task id is " + getTaskId());
        setContentView(R.layout.first_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 在活动中使用Toast
                 */
                Toast.makeText(FirstActivity.this, "You clicked the Button.", Toast.LENGTH_SHORT).show();

                /**
                 * 向下一个活动传递数据
                 */
                String data = "Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);

                /**
                 * 返回数据给上一个活动
                 */
                startActivityForResult(intent, 1);
            }
        });

        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Intent
                 */
                //显式Intent
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

                //隐式Intent
                //Intent intent = new Intent("com.example.modetest.ACTION_START");
                //intent.addCategory("com.example.modetest.MY_CATEGORY");

                startActivity(intent);
            }
        });

        Button button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 百度
                 */
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        Button button6 = (Button) findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 拨打电话
                 */
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        Button button7 = (Button) findViewById(R.id.button_7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * standard:标准模式
                 */
                Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        Button button8 = (Button) findViewById(R.id.button_8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * singleTop + singleTask + singleInstance:单顶模式+单任务模式+单实例模式
                 */
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * 创建菜单Menu选项
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * 定义菜单Menu响应事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    /**
     * 返回数据给上一个活动
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity", "onRestart");
    }
}