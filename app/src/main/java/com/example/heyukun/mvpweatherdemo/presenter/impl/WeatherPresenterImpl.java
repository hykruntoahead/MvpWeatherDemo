package com.example.heyukun.mvpweatherdemo.presenter.impl;

import com.example.heyukun.mvpweatherdemo.model.WeatherModel;
import com.example.heyukun.mvpweatherdemo.model.entity.Weather;
import com.example.heyukun.mvpweatherdemo.model.impl.WeatherModelImpl;
import com.example.heyukun.mvpweatherdemo.presenter.OnWeatherListener;
import com.example.heyukun.mvpweatherdemo.presenter.WeatherPresenter;
import com.example.heyukun.mvpweatherdemo.ui.view.WeatherView;

/**
 * Created by heyukun on 2017/8/15.
 *
 */

public class WeatherPresenterImpl implements WeatherPresenter,OnWeatherListener {
    /* presenter 作为中间层 持有View和model的引用*/
    private WeatherView weatherView;
    private WeatherModel weatherModel;

    public WeatherPresenterImpl(WeatherView weatherView ){
        this.weatherView = weatherView;
        this.weatherModel = new WeatherModelImpl();
    }

    @Override
    public void getWeather(String cityNO) {
        weatherView.showLoading();
        weatherModel.loadWeather(cityNO,this);
    }

    @Override
    public void onSuccess(Weather weather) {
        weatherView.hideLoading();
        weatherView.setWeatherInfo(weather);

    }

    @Override
    public void onError() {
        weatherView.hideLoading();
        weatherView.showError();
    }
}
