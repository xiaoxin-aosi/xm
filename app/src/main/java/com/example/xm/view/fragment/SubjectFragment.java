package com.example.xm.view.fragment;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mylibrary.base.BaseFragment;
import com.example.xm.R;
import com.example.xm.adapter.show.HotGoodsAdapter;
import com.example.xm.adapter.show.SingleTextAdapter;
import com.example.xm.adapter.sub.DataLinAdapter;
import com.example.xm.adapter.sub.SubTextAdapter;
import com.example.xm.bean.Bean;
import com.example.xm.bean.SubBean;
import com.example.xm.contract.MainContract;
import com.example.xm.presenter.MainPresenter;
import com.example.xm.presenter.SubPresenter;

import java.util.ArrayList;
import java.util.List;

public class SubjectFragment extends BaseFragment<SubPresenter> implements MainContract.SubView {


    private FragmentActivity activity;
    private RecyclerView rcy;
    private VirtualLayoutManager virtualLayoutManager;
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<SubBean.DataDTO.DataDTOS> list;
    private DataLinAdapter dataLinAdapter;
    private DelegateAdapter adapter;
    private SingleLayoutHelper singleLayoutHelper;
    private SubTextAdapter subTextAdapter;

    @Override
    protected void initView(View view) {
        rcy = view.findViewById(R.id.rcy);
        activity = getActivity();
        virtualLayoutManager = new VirtualLayoutManager(activity);
        // 创建VirtualLayoutManager对象
        // 同时内部会创建一个LayoutHelperFinder对象，用来后续的LayoutHelper查找

        // 将VirtualLayoutManager绑定到recyclerView
        //设置回收复用池大小
        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rcy.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        rcy.setLayoutManager(virtualLayoutManager);

        rcy.setLayoutManager(virtualLayoutManager);
        getDataLin();
        getText1();
        adapter = new DelegateAdapter(virtualLayoutManager);
        adapter.addAdapter(dataLinAdapter);
        adapter.addAdapter(subTextAdapter);
        rcy.setAdapter(adapter);
    }

    private void getText1() {
        singleLayoutHelper = new SingleLayoutHelper();
        subTextAdapter = new SubTextAdapter(singleLayoutHelper);
    }

    private void getDataLin() {
        linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        list=new ArrayList<>();
        dataLinAdapter = new DataLinAdapter(linearLayoutHelper, activity, list);
    }



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_subject;
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected SubPresenter getPresenter() {
        return new SubPresenter();
    }


    @Override
    public void getData(SubBean subBean) {
        Log.d("安", "getData: "+subBean.toString());
        List<SubBean.DataDTO.DataDTOS> data = subBean.getData().getData();
        list.addAll(data);
        dataLinAdapter.notifyDataSetChanged();
    }
}