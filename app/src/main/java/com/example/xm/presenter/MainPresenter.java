package com.example.xm.presenter;


import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.net.CallBack;
import com.example.xm.bean.Bean;
import com.example.xm.bean.URLConstant;
import com.example.xm.contract.MainContract;
import com.example.xm.model.MainModel;

public class MainPresenter extends BasePresenter<MainContract.IMainView,MainContract.ImainModel> implements MainContract.ImainPresenter {
    @Override
    public MainContract.ImainModel getiModel() {
        return new MainModel();
    }

    @Override
    public void getData() {
        iModel.getLoginData(URLConstant.NEWLIST, new CallBack<Bean>() {
            @Override
            public void onSuccess(Bean bean) {
                iView.getData(bean);
            }

            @Override
            public void onFail(String string) {
            }
        });
    }
}
