package com.example.heyukun.mvpweatherdemo.util.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;

/**
 * Created by heyukun on 2017/8/15.
 */

public class GsonRequest<T> extends Request<T> {
    private  Response.Listener<T> mListener;

    private static Gson mGson = new Gson();
    private Class<T> mClass;
    private TypeToken<T> mTypeToken;


    public GsonRequest(int method, String url, Class<T> clazz,Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mClass = clazz;
        mListener = listener;
    }

    public GsonRequest(int method, String url, TypeToken<T> typeToken,Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mTypeToken = typeToken;
        mListener = listener;
    }

    public GsonRequest(String url, Class<T> clazz, Response.Listener<T> listener,Response.ErrorListener errorListener) {
        this(Method.GET,url,clazz,listener,errorListener);
    }

    public GsonRequest(String url, TypeToken<T> typeToken, Response.Listener<T> listener, Response.ErrorListener errorListener){
        super(Method.GET,url,errorListener);
        mTypeToken = typeToken;
        mListener = listener;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            String jsonString = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            if(mTypeToken == null){
                return Response.success(mGson.fromJson(jsonString,mClass),HttpHeaderParser.parseCacheHeaders(networkResponse));
            }else {
                return  (Response<T>) Response.success(mGson.fromJson(jsonString,mTypeToken.getType()),
                        HttpHeaderParser.parseCacheHeaders(networkResponse));
            }
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T t) {
      mListener.onResponse(t);
    }
}
