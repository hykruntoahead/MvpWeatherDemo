package com.example.heyukun.mvpweatherdemo.ui.common;

import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * Created by heyukun on 2017/8/15.
 */

public class BaseActivity extends FragmentActivity {

    protected <T extends View> T findView(int id){
        return (T) findViewById(id);
    }

}
