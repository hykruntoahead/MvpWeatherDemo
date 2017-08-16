package com.example.heyukun.mvpweatherdemo.model;

import com.example.heyukun.mvpweatherdemo.presenter.OnWeatherListener;

/**
 * Created by heyukun on 2017/8/15.
 */

public interface WeatherModel {
    void loadWeather(String cityNO, OnWeatherListener listener);
}
