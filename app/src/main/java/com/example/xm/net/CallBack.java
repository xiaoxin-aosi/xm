package com.example.xm.net;

public interface CallBack<T> {
    public void onSuccess(T t);

    public void onFail(String string);
}
