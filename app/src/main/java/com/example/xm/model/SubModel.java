package com.example.xm.model;

import com.example.mylibrary.net.CallBack;
import com.example.xm.bean.RetrofitUtils;
import com.example.xm.bean.SubUtils;
import com.example.xm.contract.MainContract;

public class SubModel implements MainContract.SubModel{

    @Override
    public <T> void getLoginData(String url, CallBack<T> callback) {
        SubUtils.getInstance().get(url,callback);
    }
}
