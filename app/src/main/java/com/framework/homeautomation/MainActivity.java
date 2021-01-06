package com.framework.homeautomation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView image1;
    AlertDialog.Builder alert;
    SharedPreferences pref; // 0 - for private mode


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            pref = getApplicationContext().getSharedPreferences("MyPref", 0);

           alert = new AlertDialog.Builder(getApplicationContext());
           image1=(ImageView)findViewById(R.id.splash_screen);

           int splash_Display = 1000;
           new Handler().postDelayed(new Runnable(){
               @Override
               public void run() {
                   if(pref.getBoolean("isLoggedIn",false)){
                       GoToControl();
                   }
                   else{
                       GoToLogin();
                   }

                   finish();
               }
           }, splash_Display);

       }catch (Exception e){
           e.printStackTrace();
       }
    }
    private void GoToLogin(){
        Intent mainIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(mainIntent);

    }
    private void GoToControl(){
        Intent mainIntent = new Intent(MainActivity.this, ControlActivity.class);
        startActivity(mainIntent);

    }
}