package com.framework.homeautomation;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;

import android.telephony.SmsManager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Toast;

public class ControlActivity extends AppCompatActivity {
    public SwitchCompat switch1;
    public SwitchCompat switch2;
    public SwitchCompat switch3;
    public SwitchCompat switch4;
    public SwitchCompat switch5;

    SmsManager smsManager;
    static int MY_PERMISSIONS_REQUEST_SEND_SMS = 101;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        try {
            getSupportActionBar().setTitle("Home Automation");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.avgblue)));
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.setStatusBarColor(getColor(R.color.darkblue));
            }


            smsManager = SmsManager.getDefault();
            switch1 = (SwitchCompat) findViewById(R.id.switch_Button1);
            switch2 = (SwitchCompat) findViewById(R.id.switch_Button2);
            switch3 = (SwitchCompat) findViewById(R.id.switch_Button3);
            switch4 = (SwitchCompat) findViewById(R.id.switch_Button4);
            switch5 = (SwitchCompat) findViewById(R.id.switch_Button5);
            requestpermission();

            switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    try {
                        if (isChecked) {
                            PendingIntent sentPI = PendingIntent.getBroadcast(ControlActivity.this, 0, new Intent("SENT"), 0);
                            registerReceiver(new BroadcastReceiver() {
                                @Override
                                public void onReceive(Context arg0, Intent arg1) {
                                    int resultCode = getResultCode();
                                    switch (resultCode) {
                                        case Activity.RESULT_OK:
                                            Toast.makeText(getBaseContext(), "Lounge Light ON", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                                            Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_NO_SERVICE:
                                            Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_NULL_PDU:
                                            Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_RADIO_OFF:
                                            Toast.makeText(getBaseContext(), "Radio off", Toast.LENGTH_LONG).show();
                                            break;
                                    }
                                }
                            }, new IntentFilter("SENT"));
                            smsManager.sendTextMessage("+919025133722", null, "#light1ON", sentPI, null);

                        } else {
                            PendingIntent sentPI = PendingIntent.getBroadcast(ControlActivity.this, 0, new Intent("SENT"), 0);
                            registerReceiver(new BroadcastReceiver() {
                                @Override
                                public void onReceive(Context arg0, Intent arg1) {
                                    int resultCode = getResultCode();
                                    switch (resultCode) {
                                        case Activity.RESULT_OK:
                                            Toast.makeText(getBaseContext(), "Lounge Light OFF", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                                            Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_NO_SERVICE:
                                            Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_NULL_PDU:
                                            Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_RADIO_OFF:
                                            Toast.makeText(getBaseContext(), "Radio off", Toast.LENGTH_LONG).show();
                                            break;
                                    }
                                }
                            }, new IntentFilter("SENT"));
                            smsManager.sendTextMessage("+919025133722", null, "#light1OFF", sentPI, null);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    try {
                        if (isChecked) {
                            PendingIntent sentPI = PendingIntent.getBroadcast(ControlActivity.this, 0, new Intent("SENT"), 0);

                            registerReceiver(new BroadcastReceiver() {
                                @Override
                                public void onReceive(Context arg0, Intent arg1) {
                                    int resultCode = getResultCode();
                                    switch (resultCode) {
                                        case Activity.RESULT_OK:
                                            Toast.makeText(getBaseContext(), "Lounge Fan ON", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                                            Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_NO_SERVICE:
                                            Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_NULL_PDU:
                                            Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_RADIO_OFF:
                                            Toast.makeText(getBaseContext(), "Radio off", Toast.LENGTH_LONG).show();
                                            break;
                                    }
                                }
                            }, new IntentFilter("SENT"));
                            smsManager.sendTextMessage("+919025133722", null, "#light1ON", sentPI, null);

                        } else {
                            PendingIntent sentPI = PendingIntent.getBroadcast(ControlActivity.this, 0, new Intent("SENT"), 0);

                            registerReceiver(new BroadcastReceiver() {
                                @Override
                                public void onReceive(Context arg0, Intent arg1) {
                                    int resultCode = getResultCode();
                                    switch (resultCode) {
                                        case Activity.RESULT_OK:
                                            Toast.makeText(getBaseContext(), "Lounge Fan OFF", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                                            Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_NO_SERVICE:
                                            Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_NULL_PDU:
                                            Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_LONG).show();
                                            break;
                                        case SmsManager.RESULT_ERROR_RADIO_OFF:
                                            Toast.makeText(getBaseContext(), "Radio off", Toast.LENGTH_LONG).show();
                                            break;
                                    }
                                }
                            }, new IntentFilter("SENT"));
                            smsManager.sendTextMessage("+919025133722", null, "#light1OFF", sentPI, null);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        PendingIntent sentPI = PendingIntent.getBroadcast(ControlActivity.this, 0, new Intent("SENT"), 0);

                        registerReceiver(new BroadcastReceiver() {
                            @Override
                            public void onReceive(Context arg0, Intent arg1) {
                                int resultCode = getResultCode();
                                switch (resultCode) {
                                    case Activity.RESULT_OK:
                                        Toast.makeText(getBaseContext(), "Lounge Tv ON", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                                        Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                                        Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_NULL_PDU:
                                        Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                                        Toast.makeText(getBaseContext(), "Radio off", Toast.LENGTH_LONG).show();
                                        break;
                                }
                            }
                        }, new IntentFilter("SENT"));
                        smsManager.sendTextMessage("+919025133722", null, "#tv1ON", sentPI, null);
                    } else {
                        PendingIntent sentPI = PendingIntent.getBroadcast(ControlActivity.this, 0, new Intent("SENT"), 0);

                        registerReceiver(new BroadcastReceiver() {
                            @Override
                            public void onReceive(Context arg0, Intent arg1) {
                                int resultCode = getResultCode();
                                switch (resultCode) {
                                    case Activity.RESULT_OK:
                                        Toast.makeText(getBaseContext(), "Lounge Tv OFF", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                                        Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                                        Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_NULL_PDU:
                                        Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                                        Toast.makeText(getBaseContext(), "Radio off", Toast.LENGTH_LONG).show();
                                        break;
                                }
                            }
                        }, new IntentFilter("SENT"));
                        smsManager.sendTextMessage("+919025133722", null, "#tv1OFF", sentPI, null);
                    }
                }
            });
            switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        PendingIntent sentPI = PendingIntent.getBroadcast(ControlActivity.this, 0, new Intent("SENT"), 0);

                        registerReceiver(new BroadcastReceiver() {
                            @Override
                            public void onReceive(Context arg0, Intent arg1) {
                                int resultCode = getResultCode();
                                switch (resultCode) {
                                    case Activity.RESULT_OK:
                                        Toast.makeText(getBaseContext(), "Front Light ON", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                                        Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                                        Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_NULL_PDU:
                                        Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                                        Toast.makeText(getBaseContext(), "Radio off", Toast.LENGTH_LONG).show();
                                        break;
                                }
                            }
                        }, new IntentFilter("SENT"));
                        smsManager.sendTextMessage("+919025133722", null, "#light2ON", sentPI, null);
                    } else {
                        PendingIntent sentPI = PendingIntent.getBroadcast(ControlActivity.this, 0, new Intent("SENT"), 0);

                        registerReceiver(new BroadcastReceiver() {
                            @Override
                            public void onReceive(Context arg0, Intent arg1) {
                                int resultCode = getResultCode();
                                switch (resultCode) {
                                    case Activity.RESULT_OK:
                                        Toast.makeText(getBaseContext(), "Front Light OFF", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                                        Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                                        Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_NULL_PDU:
                                        Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                                        Toast.makeText(getBaseContext(), "Radio off", Toast.LENGTH_LONG).show();
                                        break;
                                }
                            }
                        }, new IntentFilter("SENT"));
                        smsManager.sendTextMessage("+919025133722", null, "#light2OFF", sentPI, null);
                    }
                }
            });
            switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        PendingIntent sentPI = PendingIntent.getBroadcast(ControlActivity.this, 0, new Intent("SENT"), 0);

                        registerReceiver(new BroadcastReceiver() {
                            @Override
                            public void onReceive(Context arg0, Intent arg1) {
                                int resultCode = getResultCode();
                                switch (resultCode) {
                                    case Activity.RESULT_OK:
                                        Toast.makeText(getBaseContext(), "Back Light ON", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                                        Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                                        Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_NULL_PDU:
                                        Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                                        Toast.makeText(getBaseContext(), "Radio off", Toast.LENGTH_LONG).show();
                                        break;
                                }
                            }
                        }, new IntentFilter("SENT"));
                        smsManager.sendTextMessage("+919025133722", null, "#light3ON", sentPI, null);
                    } else {
                        PendingIntent sentPI = PendingIntent.getBroadcast(ControlActivity.this, 0, new Intent("SENT"), 0);

                        registerReceiver(new BroadcastReceiver() {
                            @Override
                            public void onReceive(Context arg0, Intent arg1) {
                                int resultCode = getResultCode();
                                switch (resultCode) {
                                    case Activity.RESULT_OK:
                                        Toast.makeText(getBaseContext(), "Back Light OFF", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                                        Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                                        Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_NULL_PDU:
                                        Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_LONG).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                                        Toast.makeText(getBaseContext(), "Radio off", Toast.LENGTH_LONG).show();
                                        break;
                                }
                            }
                        }, new IntentFilter("SENT"));
                        smsManager.sendTextMessage("+919025133722", null, "#light4OFF", sentPI, null);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void requestpermission() {
        try {

            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.SEND_SMS)
                    != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.SEND_SMS)) {
                } else {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.SEND_SMS},
                            MY_PERMISSIONS_REQUEST_SEND_SMS);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        try {
            if (MY_PERMISSIONS_REQUEST_SEND_SMS == requestCode) {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}