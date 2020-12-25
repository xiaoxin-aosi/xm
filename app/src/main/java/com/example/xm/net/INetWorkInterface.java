package com.example.xm.net;

import java.util.HashMap;

public interface INetWorkInterface {
    public <T> void get(String url, CallBack<T> callBack);

    public <T> void post(String url, CallBack<T> callBack);

    public <T> void post(String url, HashMap<String, String> map, CallBack<T> callBack);
}
