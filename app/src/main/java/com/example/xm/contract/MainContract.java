package com.example.xm.contract;


import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.base.BaseView;
import com.example.mylibrary.net.CallBack;
import com.example.xm.bean.Bean;
import com.example.xm.bean.SubBean;

public class MainContract {
    //首页
    public interface ImainModel extends BaseModel {
        <T> void getLoginData(String url, CallBack<T> callback);
    }
    public interface ImainPresenter{
        void getData();
    }
    public interface IMainView extends BaseView {
        void getData(Bean bean);
    }
//专题
    public interface SubModel extends BaseModel {
        <T> void getLoginData(String url, CallBack<T> callback);
    }
    public interface SubPresenter{
        void getData();
    }
    public interface SubView extends BaseView {
        void getData(SubBean subBean);
    }
}









