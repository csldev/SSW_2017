package com.compassl.anji.ssw_2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = (Button) findViewById(R.id.bt_01);
        Button bt2 = (Button) findViewById(R.id.bt_02);
        Button bt3 = (Button) findViewById(R.id.bt_03);
        Button bt4 = (Button) findViewById(R.id.bt_04);
        Button bt5 = (Button) findViewById(R.id.bt_05);
        Button bt6 = (Button) findViewById(R.id.bt_06);
        Button bt7 = (Button) findViewById(R.id.bt_07);
        Button bt8 = (Button) findViewById(R.id.bt_08);
        Button bt9 = (Button) findViewById(R.id.bt_09);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt_01 :
                Playing.actionStart(MainActivity.this,1);
                break;
            case R.id.bt_02 :
                Playing.actionStart(MainActivity.this,2);
                break;
            case R.id.bt_03 :
                Playing.actionStart(MainActivity.this,3);
                break;
            case R.id.bt_04 :
                Playing.actionStart(MainActivity.this,4);
                break;
            case R.id.bt_05 :
                Playing.actionStart(MainActivity.this,5);
                break;
            case R.id.bt_06 :
                Playing.actionStart(MainActivity.this,6);
                break;
            case R.id.bt_07 :
                Playing.actionStart(MainActivity.this,7);
                break;
            case R.id.bt_08 :
                Playing.actionStart(MainActivity.this,8);
                break;
            case R.id.bt_09 :
                Playing.actionStart(MainActivity.this,9);
                break;
        }
    }
}
