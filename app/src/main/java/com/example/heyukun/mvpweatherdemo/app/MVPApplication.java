package com.example.heyukun.mvpweatherdemo.app;

import android.app.Application;

import com.example.heyukun.mvpweatherdemo.util.volley.VolleyRequest;

/**
 * Created by heyukun on 2017/8/15.
 */

public class MVPApplication extends Application {
    private static MVPApplication instance;

    public MVPApplication(){
        instance = this;
    }

    public static Application getContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyRequest.buildRequestQueue(this);
    }
}
