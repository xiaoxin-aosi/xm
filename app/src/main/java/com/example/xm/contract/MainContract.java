package com.example.xm.contract;


import com.example.xm.base.BaseModel;
import com.example.xm.base.BaseView;
import com.example.xm.net.Bean;
import com.example.xm.net.CallBack;

public class MainContract {
    public interface ImainModel extends BaseModel {
        <T> void getLoginData(String url, CallBack<T> callback);
    }
    public interface ImainPresenter{
        void getData();
    }
    public interface IMainView extends BaseView {
        void getData(Bean bean);
    }
}









