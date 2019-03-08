package com.bs.newactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 2019/3/8.
 */
/**
 * <pre>
 *      author : WangChaowei
 *      time   : 2018/2/27.
 *      desc   : 自定义适配器，继承自BaseAdapter
 * </pre>
 */
public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private List<ListBean> mData;
    private CallBackInterface mCallBackInterface;//回调接口

    /**
     * 有参构造
     * @param mContext
     * @param mData
     * @param mCallBackInterface
     */
    public MyAdapter(Context mContext, List<ListBean> mData, CallBackInterface mCallBackInterface) {
        this.mContext = mContext;
        this.mData = mData;
        this.mCallBackInterface = mCallBackInterface;
    }
    /**
     * listView的item总数
     */
    @Override
    public int getCount() {
        return mData.size();
    }
    /**
     *  获取每一项数据
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }
    /**
     * 获取数据ID
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }
    /**
     * 项显示的view
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        ListBean listBean = mData.get(position);

        //convertView用于将加载好的布局进行缓存，先判断是否为空，可优化listView
        if (convertView == null){
            viewHolder = new ViewHolder();

            //1、引用layout布局
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_view_layout, parent, false);
            //2、填充当前项的数据
            viewHolder.textView = (TextView) convertView.findViewById(R.id.listView_TextView);
            viewHolder.button = (Button) convertView.findViewById(R.id.button_item);

            convertView.setTag(viewHolder); //3、在view上保存所需数据
        }else {
            viewHolder =  (ViewHolder) convertView.getTag();
        }

        //设置数据
        viewHolder.textView.setText(listBean.getmText());
        listBean.setmCurrentPos(position);

        //listview中的点击事件
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBackInterface.callBackClick(position);
            }
        });
        return convertView;

    }
    /**
     * ViewHolder通常出现在适配器里，为的是listview滚动的时候快速设置值，而不必每次都重新创建很多对象，从而提升性能
     */
    private static class ViewHolder{
        TextView textView;
        Button button;
    }
}
