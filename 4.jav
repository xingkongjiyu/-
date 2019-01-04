package com.njupt.t4;  

import android.os.Bundle;  
import android.app.Activity;  
import android.content.IntentFilter;  
import android.view.Menu;  

public class MainActivity extends Activity {  

    private SmsReceiver receiver = new SmsReceiver();  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  

        IntentFilter filter = new IntentFilter();  
        filter.setPriority(997);  
        filter.addAction("android.provider.Telephony.SMS_RECEIVED");  
        registerReceiver(receiver,filter);  
    }  

    @Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        // Inflate the menu; this adds items to the action bar if it is present.  
        getMenuInflater().inflate(R.menu.main, menu);  
        return true;  
    }  

    @Override  
    protected void onDestroy() {  
        super.onDestroy();  

        unregisterReceiver(receiver);  
    }  
}  

