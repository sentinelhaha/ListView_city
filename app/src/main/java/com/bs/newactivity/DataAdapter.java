package com.bs.newactivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2019/3/3.
 */

public class DataAdapter extends ArrayAdapter<Data>{
    private int resourceId;
    private Data product;
    private ArrayList<Data> productList = new ArrayList<>();
    public DataAdapter(Context context, int resource, List<Data> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Data product = getItem(position);
        View productView = LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView name = (TextView) productView.findViewById(R.id.product_Name);
        TextView status = (TextView) productView.findViewById(R.id.product_buy_status);
        TextView lend_money = (TextView) productView.findViewById(R.id.product_lend_money);
        TextView interest = (TextView) productView.findViewById(R.id.product_interst);
        TextView date = (TextView) productView.findViewById(R.id.product_date);
        name.setText(product.name);
        status.setText(product.status);
        lend_money.setText(product.lend_money);
        interest.setText(product.interest);
        date.setText(product.date);

        return productView;
    }





}
