package com.framework.homeautomation;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private ImageView imageView1;
    private EditText editText1;
    private EditText editText2;
    private Button button1;
    private ImageView imageView2;
    private int counter;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        editText1=(EditText)findViewById(R.id.edit_phone_number);
        editText2=(EditText)findViewById(R.id.edit_phone_number);
        button1=(Button)findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editText1.getText().toString();
                String password = editText2.getText().toString();
                editor.putString("username",username);
                editor.putString("password",password);
                editor.putBoolean("isLoggedIn",true);
                editor.apply();
            }


        });

    }



}