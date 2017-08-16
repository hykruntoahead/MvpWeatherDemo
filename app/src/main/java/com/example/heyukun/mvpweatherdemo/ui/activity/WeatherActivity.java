package com.example.heyukun.mvpweatherdemo.ui.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heyukun.mvpweatherdemo.R;
import com.example.heyukun.mvpweatherdemo.model.entity.Weather;
import com.example.heyukun.mvpweatherdemo.model.entity.WeatherInfo;
import com.example.heyukun.mvpweatherdemo.presenter.WeatherPresenter;
import com.example.heyukun.mvpweatherdemo.presenter.impl.WeatherPresenterImpl;
import com.example.heyukun.mvpweatherdemo.ui.common.BaseActivity;
import com.example.heyukun.mvpweatherdemo.ui.view.WeatherView;


/**
 * Created by heyukun on 2017/8/15.
 */

public class WeatherActivity extends BaseActivity implements WeatherView,View.OnClickListener {

    private Dialog mLoadingDialog;
    private EditText cityNoInput;
    private TextView city;
    private TextView cityNO;
    private TextView temp;
    private TextView wd;
    private TextView ws;
    private TextView sd;
    private TextView wse;
    private TextView time;
    private TextView njd;

    private WeatherPresenter weatherPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
    }

    private void initWidgets() {
        cityNoInput = findView(R.id.et_city_no);
        city = findView(R.id.tv_city);
        cityNO = findView(R.id.tv_city_no);
        temp = findView(R.id.tv_temp);
        wd = findView(R.id.tv_WD);
        ws = findView(R.id.tv_WS);
        sd = findView(R.id.tv_SD);
        wse = findView(R.id.tv_WSE);
        time = findView(R.id.tv_time);
        njd = findView(R.id.tv_njd);

        findView(R.id.btn_go).setOnClickListener(this);

        weatherPresenter = new WeatherPresenterImpl(this);//传入weatherView
        mLoadingDialog = new ProgressDialog(this);
        mLoadingDialog.setTitle(R.string.load_weather);
    }

    @Override
    public void onClick(View v) {
        Log.i("onClick","onClick--Go--0");
        switch (v.getId()){
            case R.id.btn_go:
                Log.i("onClick","onClick--Go--1");
                weatherPresenter.getWeather(cityNoInput.getText().toString().trim());
                break;
        }

    }

    @Override
    public void showLoading() {
        mLoadingDialog.show();
    }

    @Override
    public void hideLoading() {
        mLoadingDialog.hide();
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(),R.string.error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setWeatherInfo(Weather weather) {
        WeatherInfo info = weather.getWeatherInfo();
        city.setText(info.getCity());
        cityNO.setText(info.getCityId());
        temp.setText(info.getTemp());
        wd.setText(info.getWD());
        ws.setText(info.getWS());
        sd.setText(info.getSD());
        wse.setText(info.getTemp());
        time.setText(info.getTemp());
        njd.setText(info.getNjd());
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mLoadingDialog!=null ) {
            if (mLoadingDialog.isShowing()) {
                mLoadingDialog.hide();
            }
            mLoadingDialog.cancel();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
