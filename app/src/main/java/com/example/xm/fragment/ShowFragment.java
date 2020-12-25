package com.example.xm.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.xm.R;
import com.example.xm.adapter.SingleAdapter;
import com.example.xm.net.Bean;

import java.util.ArrayList;


public class ShowFragment extends Fragment {


    private SearchView sch;
    private RecyclerView rcy;
    private ArrayList<Bean.DataDTO.BannerDTO> imgs;

    public ShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        sch = view.findViewById(R.id.sch);
        rcy = view.findViewById(R.id.rcy);

        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity());
        // 创建VirtualLayoutManager对象
        // 同时内部会创建一个LayoutHelperFinder对象，用来后续的LayoutHelper查找

        rcy.setLayoutManager(layoutManager);
        // 将VirtualLayoutManager绑定到recyclerView
        //设置回收复用池大小
        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rcy.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        /**
         设置通栏布局
         banner
         */
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(3);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        imgs = new ArrayList<>();
        SingleAdapter singleAdapter = new SingleAdapter(getActivity(),imgs,singleLayoutHelper);

    }
}