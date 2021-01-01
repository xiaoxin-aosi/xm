package com.example.mylibrary.base;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    public V iView;
    public M iModel;
    public void attachView(V v){
        iView=v;
        iModel=getiModel();
    }

    public abstract M getiModel();

    public void deTachView(){
        iView=null;
        iModel=null;
    }
}
