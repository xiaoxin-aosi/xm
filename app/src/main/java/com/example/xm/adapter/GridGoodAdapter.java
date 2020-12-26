package com.example.xm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.xm.R;
import com.example.xm.net.Bean;

import java.util.ArrayList;

public class GridGoodAdapter extends DelegateAdapter.Adapter {
    private final GridLayoutHelper gridLayoutHelper;
    private final ArrayList<Bean.DataDTO.NewGoodsListDTO> goods;
    private final Context context;

    public GridGoodAdapter(GridLayoutHelper gridLayoutHelper, ArrayList<Bean.DataDTO.NewGoodsListDTO> goods, Context context) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.goods = goods;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_goodes, parent, false);
        return new GridGoodViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridGoodViewHolder viewHolder = (GridGoodViewHolder) holder;
        Bean.DataDTO.NewGoodsListDTO newGoodsListDTO = goods.get(position);
        Glide.with(context).load(newGoodsListDTO.getList_pic_url()).into(viewHolder.iv_goods);
        viewHolder.tv_goods_name.setText(newGoodsListDTO.getName());
        viewHolder.tv_goods_price.setText("￥"+newGoodsListDTO.getRetail_price());
    }

    @Override
    public int getItemCount() {
        return goods.size();
    }

    class GridGoodViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_goods;
        private final TextView tv_goods_name;
        private final TextView tv_goods_price;

        public GridGoodViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_goods = itemView.findViewById(R.id.iv_goods);
            tv_goods_name = itemView.findViewById(R.id.tv_goods_name);
            tv_goods_price = itemView.findViewById(R.id.tv_goods_price);
        }
    }
}
