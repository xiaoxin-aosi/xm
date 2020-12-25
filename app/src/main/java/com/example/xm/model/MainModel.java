package com.example.xm.model;

import com.example.xm.contract.MainContract;
import com.example.xm.net.CallBack;
import com.example.xm.net.RetrofitUtils;

public class MainModel implements MainContract.ImainModel {
    @Override
    public <T> void getLoginData(String url, CallBack<T> callback) {
        RetrofitUtils.getInstance().get(url,callback);
    }
}
