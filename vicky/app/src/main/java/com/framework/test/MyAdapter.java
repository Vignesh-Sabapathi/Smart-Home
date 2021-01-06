package com.framework.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private MyData myData;
    public List<MyData.Docs> docsList;
    private TextView serialNum, name, contactNum;
    public MyAdapter(Context context, MyData myData) {
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        serialNum = convertView.findViewById(R.id.serailNumber);
        name = convertView.findViewById(R.id.studentName);
        contactNum = convertView.findViewById(R.id.mobileNum);
        serialNum.setText(" " + docsList.get(position).id);
        name.setText(docsList.get(position).journal);
        contactNum.setText(docsList.get(position).eissn);
        return convertView;
    }
}
