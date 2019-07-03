package com.example.myeventbus;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@BindEventBus
public class Main2Activity extends BaseActivity {


    private static final String TAG = "cj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EventBus.getDefault().post(3);
            }
        });
    }


    @Subscribe(sticky = true)
    public void onGetStringEvent(String string) {
        Log.e(TAG, "activity 2 string " + string);
    }
}
