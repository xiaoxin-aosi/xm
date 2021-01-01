package com.example.xm.bean;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mylibrary.net.ApiService;
import com.example.mylibrary.net.CallBack;
import com.example.mylibrary.net.INetWorkInterface;
import com.google.gson.Gson;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


public class RetrofitUtils implements INetWorkInterface {

    private static RetrofitUtils retrofitUtils;
    private ApiService apiService;

    private RetrofitUtils() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConstant.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                retrofitUtils = new RetrofitUtils();
            }
        }
        return retrofitUtils;
    }

    @Override
    public <T> void get(String url, CallBack<T> callBack) {
        apiService.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = actualTypeArguments[0];
                            T result = new Gson().fromJson(string, type);
                            callBack.onSuccess(result);
                        } catch (Exception e) {

                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("TAG", "onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

//    @Override
//    public <T> void post(String url, CallBack<T> callBack) {
//        apiService.post(url)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new Observer<ResponseBody>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                    }
//
//                    @Override
//                    public void onNext(@NonNull ResponseBody responseBody) {
//                        try {
//                            String string = responseBody.string();
//                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
//                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
//                            Type type = actualTypeArguments[0];
//                            T result = new Gson().fromJson(string, type);
//                            callBack.onSuccess(result);
//                        } catch (Exception e) {
//
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
//
//    @Override
//    public <T> void post(String url, HashMap<String, String> map, CallBack<T> callBack) {
//        apiService.post(url, map)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new Observer<ResponseBody>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                    }
//
//                    @Override
//                    public void onNext(@NonNull ResponseBody responseBody) {
//                        try {
//                            String string = responseBody.string();
//                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
//                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
//                            Type type = actualTypeArguments[0];
//                            T result = new Gson().fromJson(string, type);
//                            callBack.onSuccess(result);
//                        } catch (Exception e) {
//
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
}
