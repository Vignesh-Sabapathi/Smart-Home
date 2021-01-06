package com.framework.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private TextView src;
    public MyData myData;
    private  ImageView Imageview;
    private FloatingActionButton Fltbtn;
    APIInterface apiInterface;
    MyAdapter adapter;
    DBAdapter db;
    private ListView list;
    ArrayList<ArrayList<String>> contactlist =new ArrayList();
    private GridView gridview;
    private TextView textView;
    private ImageView imagev;

    public Boolean bool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.listid);

        gridview=(GridView)findViewById(R.id.grid1);
        imagev=(ImageView)findViewById(R.id.imag);
//
        Retrofit retrofit= APIClient.getClient();
        apiInterface = retrofit.create(APIInterface.class);
//        InterfaceForCategory categoryService = retrofit.create(InterfaceForCategory.class);
        Call<MyData> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<MyData>() {
            @Override
            public void onResponse(Call<MyData> call, Response<MyData> response) {
                Log.d("TAG",response.code()+"");
                String displayResponse = "";
                myData = response.body();
                adapter = new MyAdapter(MainActivity.this, myData);
                list.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<MyData> call, Throwable t) {
                int i=1;

            }
        });
        imagev.setOnClickListener(new View.OnClickListener() {

           @Override
            public void onClick(View v) {
                if(list.getVisibility()==View.VISIBLE){
                    list.setVisibility(View.GONE);
                    gridview.setVisibility(View.VISIBLE);
                    db=new DBAdapter(MainActivity.this,myData);
                    gridview.setAdapter(db);
                }
                else{
                    list.setVisibility(View.VISIBLE);
                    gridview.setVisibility(View.GONE);
                    adapter = new MyAdapter(MainActivity.this, myData);
                    list.setAdapter(adapter);
                }
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("mydata",myData);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });


    }

    public void fetch(){


    }

}
