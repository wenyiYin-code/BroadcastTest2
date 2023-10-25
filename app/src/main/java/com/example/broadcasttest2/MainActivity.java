package com.example.broadcasttest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilterTest2;
    private Receiver receiverTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilterTest2 = new IntentFilter();
        intentFilterTest2.addAction("com.example.MyBroadcast");
        intentFilterTest2.setPriority(100);
        receiverTest2 = new Receiver();
        registerReceiver(receiverTest2, intentFilterTest2);
    }

    class Receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "receiverTest2：" + context.toString(), Toast.LENGTH_SHORT).show();
            abortBroadcast();
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unregisterReceiver(receiverTest2);
    }


}