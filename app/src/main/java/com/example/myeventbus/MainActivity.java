package com.example.myeventbus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@BindEventBus
public class MainActivity extends BaseActivity {

    private static final String TAG = "cj";
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textView);


        EventBus.getDefault().post("hehe");
        EventBus.getDefault().post(2);


        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }

    @SuppressWarnings("unused")
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(Integer string) {
        Log.e(TAG, "onEvent: " + string);
        textview.setText("" + string);
    }


    @Subscribe
    public void onGetStringEvent(String string) {
        Log.e(TAG, "onGetStringEvent:只收string " + string);
    }


}
