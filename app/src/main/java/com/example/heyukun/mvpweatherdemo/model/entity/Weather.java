package com.example.heyukun.mvpweatherdemo.model.entity;

/**
 * Created by heyukun on 2017/8/15.
 * 天气实体类
 */

public class Weather {
    private WeatherInfo weatherInfo;
    public WeatherInfo getWeatherInfo(){
        return weatherInfo;
    }
    public void setWeatherInfo(WeatherInfo weatherInfo){
        this.weatherInfo = weatherInfo;
    }


}
