package com.example.heyukun.mvpweatherdemo.util.volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

/**
 * Created by heyukun on 2017/8/15.
 */

public class VolleyRequest {
    private static RequestQueue mRequestQueue;

    private VolleyRequest(){}

    public static void buildRequestQueue(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
    }
    public static VolleyRequest newInstance(){
        if (mRequestQueue == null){
            throw new NullPointerException("call buildRequestQueue method first.");
        }
        return new VolleyRequest();
    }

    public <T> GsonRequest<T> newGsonrequest(String url, Class<T> clazz, Response.Listener<T> listener,
                                             Response.ErrorListener errorListener){
        GsonRequest<T> request = new GsonRequest<T>(url,clazz,listener,errorListener);
        mRequestQueue.add(request);
        return request;
    }

}
