package com.example.xm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.xm.R;
import com.example.xm.net.Bean;

import java.util.ArrayList;

public class HotGoodsAdapter extends DelegateAdapter.Adapter {
    private final LinearLayoutHelper linearLayoutHelper;
    private final Context context;
    private final ArrayList<Bean.DataDTO.HotGoodsListDTO> hots;

    public HotGoodsAdapter(LinearLayoutHelper linearLayoutHelper, Context context, ArrayList<Bean.DataDTO.HotGoodsListDTO> hots) {
        this.linearLayoutHelper = linearLayoutHelper;
        this.context = context;
        this.hots = hots;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hotgoods, parent, false);
        return new HotGoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HotGoodViewHolder viewHolder= (HotGoodViewHolder) holder;
        Bean.DataDTO.HotGoodsListDTO hotGoodsListDTO = hots.get(position);
        Glide.with(context).load(hotGoodsListDTO.getList_pic_url()).into(viewHolder.iv_hot);
        viewHolder.tv_hot_name.setText(hotGoodsListDTO.getName());
        viewHolder.tv_hot_brief.setText(hotGoodsListDTO.getGoods_brief());
        viewHolder.tv_hot_price.setText("￥"+hotGoodsListDTO.getRetail_price());
    }

    @Override
    public int getItemCount() {
        return hots.size();
    }
    class HotGoodViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_hot;
        private final TextView tv_hot_name;
        private final TextView tv_hot_brief;
        private final TextView tv_hot_price;

        public HotGoodViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_hot = itemView.findViewById(R.id.iv_hot);
            tv_hot_name = itemView.findViewById(R.id.tv_hot_name);
            tv_hot_brief = itemView.findViewById(R.id.tv_hot_brief);
            tv_hot_price = itemView.findViewById(R.id.tv_hot_price);
        }
    }
}
