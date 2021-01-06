package com.framework.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    public List<MyData.Docs> docsList;
    private TextView S_num, Name, phnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        MyData myData=intent.getExtras().getParcelable("mydata");
        int position=intent.getExtras().getInt("position");
        docsList=myData.response.docs;
        S_num = (TextView)findViewById(R.id.list_text1);
        Name = (TextView)findViewById(R.id.list_text2);
        phnum = (TextView)findViewById(R.id.list_text3);
        S_num.setText(docsList.get(position).id);
        Name.setText(docsList.get(position).journal);
        phnum.setText(docsList.get(position).eissn);



    }
}