package com.example.xm.presenter;

import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.net.CallBack;
import com.example.xm.bean.SubBean;
import com.example.xm.bean.URLConstant;
import com.example.xm.contract.MainContract;
import com.example.xm.model.SubModel;

public class SubPresenter extends BasePresenter<MainContract.SubView, MainContract.SubModel> implements MainContract.SubPresenter {


    @Override
    public MainContract.SubModel getiModel() {
        return new SubModel();
    }

    @Override
    public void getData() {
        iModel.getLoginData(URLConstant.NEWLISTS, new CallBack<SubBean>() {

            @Override
            public void onSuccess(SubBean subBean) {
                iView.getData(subBean);
            }

            @Override
            public void onFail(String string) {

            }
        });
    }
}
