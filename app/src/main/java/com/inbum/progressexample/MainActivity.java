package com.inbum.progressexample;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    Handler mHandler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            dismissProgress();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showProgress(View view) {
        showProgress();

        // hide progress 2 sec later
        mHandler.postDelayed(r, 2000);
    }
}
