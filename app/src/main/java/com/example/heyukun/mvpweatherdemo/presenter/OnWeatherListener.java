package com.example.heyukun.mvpweatherdemo.presenter;

import com.example.heyukun.mvpweatherdemo.model.entity.Weather;

/**
 * Created by heyukun on 2017/8/15.
 */

public interface OnWeatherListener {
    /**
     * 成功时回调
     *
     */
    void onSuccess(Weather weather);

    /**
     * 失败时的回调
     */
    void onError();
}
