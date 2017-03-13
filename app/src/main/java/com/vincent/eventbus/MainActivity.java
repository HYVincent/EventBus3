package com.vincent.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.vincent.eventbus.utils.EventBusUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: "+String.valueOf(System.currentTimeMillis()));
        EventBusUtils.register(this);
        Log.d(TAG, "onCreate: "+String.valueOf(System.currentTimeMillis()));
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                EventBus.getDefault().post(new EventMsg("a"));
                EventBusUtils.post(new EventMsg("a"));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void action(EventMsg eventMsg){
        if(eventMsg.getMsg().equals("a")){
            Toast.makeText(MainActivity.this,"收到消息了",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtils.unRegister(this);
    }
}
