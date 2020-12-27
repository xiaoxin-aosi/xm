package com.example.xm.view.fragment;

import android.graphics.Color;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.xm.R;
import com.example.xm.adapter.GridAdapter;
import com.example.xm.adapter.GridGoodAdapter;
import com.example.xm.adapter.GridMakeAdapter;
import com.example.xm.adapter.LinTopAdapter;
import com.example.xm.adapter.HotGoodsAdapter;
import com.example.xm.adapter.SingleAdapter;
import com.example.xm.adapter.SingleText2Adapter;
import com.example.xm.adapter.SingleText3Adapter;
import com.example.xm.adapter.SingleText4Adapter;
import com.example.xm.adapter.SingleTextAdapter;
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
    private ArrayList<Bean.DataDTO.BrandListDTO> dtos;
    private SingleTextAdapter singleTextAdapter;
    private SingleLayoutHelper singleLayoutHelper;
    private FragmentActivity activity;
    private VirtualLayoutManager virtualLayoutManager;
    private GridLayoutHelper gridLayoutHelper;
    private GridMakeAdapter gridMakeAdapter;
    private SingleText2Adapter singleText2Adapter;
    private ArrayList<Bean.DataDTO.NewGoodsListDTO> goods;
    private GridGoodAdapter gridGoodAdapter;
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<Bean.DataDTO.HotGoodsListDTO> hots;
    private HotGoodsAdapter hotGoodsAdapter;
    private SingleText3Adapter singleText3Adapter;
    private SingleText4Adapter singleText4Adapter;
    private ArrayList<Bean.DataDTO.TopicListDTO> tops;
    private SinToplistAdapter sinToplistAdapter;


    @Override
    protected void initView(View view) {
        rcy = view.findViewById(R.id.rcy);
        activity = getActivity();
        virtualLayoutManager = new VirtualLayoutManager(activity);
        // 创建VirtualLayoutManager对象
        // 同时内部会创建一个LayoutHelperFinder对象，用来后续的LayoutHelper查找
        rcy.setLayoutManager(virtualLayoutManager);
        // 将VirtualLayoutManager绑定到recyclerView
        //设置回收复用池大小
        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rcy.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 100);

        /**
         设置通栏布局
         banner
         */
        singleLayoutHelper = new SingleLayoutHelper();
        /**
         设置线性布局
         */
        linearLayoutHelper = new LinearLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
//        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
//        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
//        singleLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        rcy.setLayoutManager(virtualLayoutManager);
        getBanner();
        getGridType();
        getText1();
        getGridMake();
        getText2();
        getFrist();
        getText3();
        gethotGoods();
        getText4();
        getSinToplist();
        adapter = new DelegateAdapter(virtualLayoutManager, false);
        adapter.addAdapter(singleAdapter);
        adapter.addAdapter(mainGridAdapter);
        adapter.addAdapter(singleTextAdapter);
        adapter.addAdapter(gridMakeAdapter);
        adapter.addAdapter(singleText2Adapter);
        adapter.addAdapter(gridGoodAdapter);
        adapter.addAdapter(singleText3Adapter);
        adapter.addAdapter(hotGoodsAdapter);
        adapter.addAdapter(singleText4Adapter);
        adapter.addAdapter(sinToplistAdapter);

        rcy.setAdapter(adapter);

    }

    private void getSinToplist() {

        tops = new ArrayList<>();
        sinToplistAdapter = new SinToplistAdapter(tops,singleLayoutHelper,activity);
    }


    private void getSingleTopAdapter() {
//        new SingleTopAdapter(singleLayoutHelper);

    }

    private void getText4() {
        singleText4Adapter = new SingleText4Adapter(singleLayoutHelper);
    }

    private void getText3() {
        singleText3Adapter = new SingleText3Adapter(singleLayoutHelper);
    }

    private void gethotGoods() {
        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离

        hots = new ArrayList<>();
        hotGoodsAdapter = new HotGoodsAdapter(linearLayoutHelper, activity, hots);

    }

    private void getFrist() {
        gridLayoutHelper = new GridLayoutHelper(2);
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(25);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        goods = new ArrayList<>();
        gridGoodAdapter = new GridGoodAdapter(gridLayoutHelper, goods, getActivity());
    }

    private void getText2() {
        singleText2Adapter = new SingleText2Adapter(singleLayoutHelper);
    }

    private void getGridMake() {
        gridLayoutHelper = new GridLayoutHelper(2);
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(25);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        dtos = new ArrayList<>();
        gridMakeAdapter = new GridMakeAdapter(gridLayoutHelper, dtos, getActivity());
    }

    private void getText1() {
        singleTextAdapter = new SingleTextAdapter(singleLayoutHelper);
    }

    private void getGridType() {
        gridLayoutHelper = new GridLayoutHelper(1);
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(25);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(5);// 设置每行多少个网格
        types = new ArrayList<>();
        mainGridAdapter = new GridAdapter(gridLayoutHelper, types, getActivity());
    }

    private void getBanner() {
        imgs = new ArrayList<>();
        singleAdapter = new SingleAdapter(imgs, singleLayoutHelper);
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
        List<Bean.DataDTO.BrandListDTO> brandList = bean.getData().getBrandList();
        dtos.addAll(brandList);
        gridMakeAdapter.notifyDataSetChanged();
        List<Bean.DataDTO.NewGoodsListDTO> newGoodsList = bean.getData().getNewGoodsList();
        goods.addAll(newGoodsList);
        gridGoodAdapter.notifyDataSetChanged();
        List<Bean.DataDTO.HotGoodsListDTO> hotGoodsList = bean.getData().getHotGoodsList();
        hots.addAll(hotGoodsList);
        hotGoodsAdapter.notifyDataSetChanged();
        List<Bean.DataDTO.TopicListDTO> topicList = bean.getData().getTopicList();
        tops.addAll(topicList);
        sinToplistAdapter.notifyDataSetChanged();
    }
}

