package com.framework.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DBAdapter extends BaseAdapter {
    private Context context;
    public MyData myData;
    public List<MyData.Docs> docsList;
    private TextView serialNum,name;
    public DBAdapter(Context context,MyData myData) {
    this.context=context;
    this.myData=myData;
    docsList=myData.response.docs;
    }

    @Override
    public int getCount() {
        return docsList.size();
    }

    @Override
    public Object getItem(int position) {

            return position;
    }

    @Override
    public long getItemId(int position) {
            return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.column, parent, false);
        serialNum = convertView.findViewById(R.id.serailNumber);


        serialNum.setText(" " + docsList.get(position).id);


        return convertView;
    }
}
