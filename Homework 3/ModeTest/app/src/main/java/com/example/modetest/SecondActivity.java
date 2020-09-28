package com.example.modetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //singleTop
        Log.d("SecondActivity", this.toString());
        //singleInstance
        Log.d("SecondActivity", "Task id is " + getTaskId());
        setContentView(R.layout.second_layout);

        /**
         * 向下一个活动传递数据
         */
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        //Log.d("SecondActivity", data);

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /**
                 * 返回数据给上一个活动
                 */
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello FirstActivity");
                setResult(RESULT_OK, intent);
                finish();

                //singleInstance:单实例模式
                //Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                //startActivity(intent);
            }
        });

        Button button9 = (Button) findViewById(R.id.button_9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * singleTop + singleTask:单顶模式+单任务模式
                 */
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        Button button10 = (Button) findViewById(R.id.button_10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * singleInstance:单实例模式
                 */
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 按Back键返回数据给上一个活动
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello FirstActivity");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity", "onDestroy");
    }
}