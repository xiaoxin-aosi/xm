package com.example.xm.model;

import com.example.mylibrary.net.CallBack;
import com.example.xm.bean.RetrofitUtils;
import com.example.xm.contract.MainContract;

public class MainModel implements MainContract.ImainModel {
    @Override
    public <T> void getLoginData(String url, CallBack<T> callback) {
        RetrofitUtils.getInstance().get(url,callback);
    }
}
