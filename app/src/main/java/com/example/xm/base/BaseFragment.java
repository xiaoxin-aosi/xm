package com.example.xm.base;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xm.R;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    public P presenter;
    public BaseFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(getLayoutId(), container, false);
        if (presenter==null){
            presenter=getPresenter();
            presenter.attachView(this);
        }
        initView(view);
        initData();
        return view;
    }

    protected abstract void initView(View view);

    protected abstract int getLayoutId();

    protected abstract void initData();



    protected abstract P getPresenter();
}

//public abstract class BaseFragment<P extends BasePresenter> extends AppCompatActivity implements BaseView {
//    public P presenter;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(getLayoutId());
//        if (presenter==null){
//            presenter=getPresenter();
//            presenter.attachView(this);
//        }
//        initView();
//        initData();
//    }
//
//    protected abstract void initView();
//
//    protected abstract void initData();
//
//    protected abstract P getPresenter();
//
//    protected abstract int getLayoutId();
//}