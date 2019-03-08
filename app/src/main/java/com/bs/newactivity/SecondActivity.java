package com.bs.newactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private  ArrayList<Data> productList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        doCreateProductList();
        DataAdapter adapter = new DataAdapter(SecondActivity.this,R.layout.list_data_view,productList);
        ListView listView = (ListView) findViewById(R.id.abc);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Data product = productList.get(position);
                Toast.makeText(SecondActivity.this, product.name, Toast.LENGTH_SHORT).show();
            }
        });

    }
    private ArrayList<Data> doCreateProductList (){

        for(int i=0;i<20;i++){
            Data product = new Data();
            product.name="产品名称"+i;
            if(i%2==0){
                product.status="未认购";
            }else {
                product.status="认购成功";
            }
            product.lend_money=""+i*100+i;
            product.interest=""+i*10;
            if(i<10){
                product.date="2019-01-0"+i;
            }else {
                product.date="2019-01"+i;
            }
            productList.add(product);

        }

        return productList;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifeCycle", "SecondActivity: 我是onStart方法，我会在SecondActivity由不可见变为可见时调用");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifeCycle", "SecondActivity: 我是onResume方法，我在SecondActivity处于运行状态时调用");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifeCycle", "SecondActivity: 我是onPause方法，我会在SecondActivity暂停时调用");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifeCycle", "SecondActivity: 我是onStop方法，我会在SecondActivity停止时调用");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifeCycle", "SecondActivity: 我是onRestart方法，我会在SecondActivity从停止状态变为运行状态时调用");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifeCycle", "SecondActivity: 我是onDestroy方法，我会在SecondActivity销毁之前调用");
    }
}
