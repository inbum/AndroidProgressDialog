package com.inbum.progressexample;

import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public void showProgress(){
        MainApp.getInstance().showProgress(this, null);
    }

    public void setProgress(String message){
        MainApp.getInstance().setProgress(message);
    }

    public void dismissProgress(){
        MainApp.getInstance().dismissProgress();
    }

}
