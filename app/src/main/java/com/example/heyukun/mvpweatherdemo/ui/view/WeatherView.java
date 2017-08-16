package com.example.heyukun.mvpweatherdemo.ui.view;

import com.example.heyukun.mvpweatherdemo.model.entity.Weather;

/**
 * Created by heyukun on 2017/8/15.
 */

public interface WeatherView {
    void showLoading();
    void hideLoading();
    void showError();
    void setWeatherInfo(Weather weather);
}
