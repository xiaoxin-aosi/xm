package com.example.xm.view.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.SearchView;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.xm.R;
import com.example.xm.adapter.GridAdapter;
import com.example.xm.adapter.SingleAdapter;
import com.example.xm.base.BaseFragment;
import com.example.xm.contract.MainContract;
import com.example.xm.net.Bean;
import com.example.xm.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;


public class ShowFragment extends BaseFragment<MainPresenter> implements MainContract.IMainView {

    private RecyclerView rcy;
    private ArrayList<Bean.DataDTO.BannerDTO> imgs;
    private SingleAdapter singleAdapter;
    private DelegateAdapter adapter;
    private GridAdapter mainGridAdapter;
    private ArrayList<Bean.DataDTO.ChannelDTO> types;

    @Override
    protected void initView(View view) {
        rcy = view.findViewById(R.id.rcy);

        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        // 创建VirtualLayoutManager对象
        // 同时内部会创建一个LayoutHelperFinder对象，用来后续的LayoutHelper查找
        rcy.setLayoutManager(virtualLayoutManager);
        // 将VirtualLayoutManager绑定到recyclerView
        //设置回收复用池大小
        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rcy.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        rcy.setLayoutManager(virtualLayoutManager);
        getBanner();
        getGridType();

        adapter = new DelegateAdapter(virtualLayoutManager, true);
        adapter.addAdapter(singleAdapter);
        adapter.addAdapter(mainGridAdapter);
        rcy.setAdapter(adapter);
    }

    private void getGridType() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(5);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
//        gridLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
// gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(25);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(5);// 设置每行多少个网格
        types = new ArrayList<>();
        mainGridAdapter = new GridAdapter(gridLayoutHelper,types,getActivity());
    }

    private void getBanner() {
        /**
         设置通栏布局
         banner
         */
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
//        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
//        singleLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        imgs = new ArrayList<>();
        singleAdapter = new SingleAdapter(imgs,singleLayoutHelper);
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_show;
    }

    @Override
    public void getData(Bean bean) {
        List<Bean.DataDTO.BannerDTO> banner = bean.getData().getBanner();
        imgs.addAll(banner);
        singleAdapter.notifyDataSetChanged();
        List<Bean.DataDTO.ChannelDTO> channel = bean.getData().getChannel();
        types.addAll(channel);
        mainGridAdapter.notifyDataSetChanged();

    }
}

