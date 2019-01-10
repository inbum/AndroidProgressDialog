package com.inbum.progressexample;

import android.app.Activity;
import android.app.Application;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatDialog;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainApp extends Application {

    private static MainApp mainApp;
    AppCompatDialog progressDialog;


    public static MainApp getInstance(){
        return mainApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mainApp = this;
    }

    public void showProgress(Activity activity, String message){

        if ( activity == null || activity.isFinishing() ){
            return;
        }

        if ( progressDialog != null && progressDialog.isShowing() ){
            setProgress(message);
        } else {
            progressDialog = new AppCompatDialog(activity);
            progressDialog.setCancelable(false);
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            progressDialog.setContentView(R.layout.progress_loading);
            progressDialog.show();
        }

        final ImageView img_loading_frame = (ImageView) progressDialog.findViewById(R.id.iv_frame_loading);
        final AnimationDrawable frameAnimation = (AnimationDrawable) img_loading_frame.getBackground();
        img_loading_frame.post(new Runnable() {
            @Override
            public void run() {
                frameAnimation.start();
            }
        });

        TextView tv_progress_message = (TextView) progressDialog.findViewById(R.id.tv_progress_message);
        if(!TextUtils.isEmpty(message)){
            tv_progress_message.setText(message);
        }
    }

    public void setProgress(String message){

        if ( progressDialog == null && !progressDialog.isShowing() ){
            return;
        }

        TextView tv_progress_message = (TextView) progressDialog.findViewById(R.id.tv_progress_message);
        if(!TextUtils.isEmpty(message)){
            tv_progress_message.setText(message);
        }

    }

    public void dismissProgress(){

        if ( progressDialog != null && progressDialog.isShowing() ){
            progressDialog.dismiss();
        }

    }
}
