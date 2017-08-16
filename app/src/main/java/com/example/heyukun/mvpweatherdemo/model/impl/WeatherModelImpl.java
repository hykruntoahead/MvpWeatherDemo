package com.example.heyukun.mvpweatherdemo.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.heyukun.mvpweatherdemo.model.WeatherModel;
import com.example.heyukun.mvpweatherdemo.model.entity.Weather;
import com.example.heyukun.mvpweatherdemo.presenter.OnWeatherListener;
import com.example.heyukun.mvpweatherdemo.util.volley.VolleyRequest;

/**
 * Created by heyukun on 2017/8/15.
 * 天气model实现
 */

public class WeatherModelImpl implements WeatherModel{
    @Override
    public void loadWeather(String cityNO, final OnWeatherListener listener) {
        VolleyRequest.newInstance().newGsonrequest("http://www.weather.com.cn/data/sk/" + cityNO + ".html",
                Weather.class, new Response.Listener<Weather>() {
                    @Override
                    public void onResponse(Weather weather) {
                        if(weather != null){
                            listener.onSuccess(weather);
                        }else {
                            listener.onError();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        listener.onError();
                    }
                });
    }
}
