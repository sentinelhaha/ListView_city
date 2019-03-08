package com.bs.newactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,CallBackInterface{
    private Button button_add;

    private ListView listView;
    private MyAdapter myAdapter;
    private List<ListBean> mData;

    private ListBean listBean;
    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();


        final Main2Activity myImageView = (Main2Activity) findViewById(R.id.image_view);
        myImageView.isUseCache = true;
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //直接把网络的图片路径写上就可以显示网络的图片了
                myImageView.setImageURL("http://180.178.56.50:8002/static/lunbo/15470219770411553.jpg");
            }
        });

    }
    /**
     * 初始化组件
     */
    private void initView() {
        button_add = (Button)findViewById(R.id.button_add);
        listView = (ListView)findViewById(R.id.listView);

        button_add.setOnClickListener(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Item点击，第" + position + "行",Toast.LENGTH_SHORT).show();
                button_add.setText("获取该行的值：" + mData.get(position).getmText());
            }
        });
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mData = new ArrayList<>();
        mData.add(new ListBean("来数数吧"));

        myAdapter = new MyAdapter(this,mData,this);
        listView.setAdapter(myAdapter); //listView关联适配器
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_add :
                listBean = new ListBean();
                listBean.setmText(String.valueOf(num));

                mData.add(listBean);
                myAdapter.notifyDataSetChanged(); //更新适配器

                num ++;
                break;
        }
    }

    @Override
    public void callBackClick(int position) {
        Toast.makeText(this,"按钮点击，当前行：" + (position + 1),Toast.LENGTH_SHORT).show();
    }

}











