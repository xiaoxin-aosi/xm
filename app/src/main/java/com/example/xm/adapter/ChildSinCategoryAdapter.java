package com.example.xm.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.xm.R;
import com.example.xm.net.Bean;

import java.util.List;

public class ChildSinCategoryAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final List<Bean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList;

    public ChildSinCategoryAdapter(Context context, List<Bean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList) {
        this.context = context;
        this.goodsList = goodsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_child_sincategory, parent, false);
        return new ChildSinCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChildSinCategoryViewHolder viewHolder= (ChildSinCategoryViewHolder) holder;
        Bean.DataDTO.CategoryListDTO.GoodsListDTO listDTO = goodsList.get(position);
        Glide.with(context).load(listDTO.getList_pic_url())
                .into(viewHolder.iv_sincategory);
        viewHolder.tv_sincategory_name.setText(listDTO.getName());
        viewHolder.tv_sincategory_price.setText("￥"+listDTO.getRetail_price());
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }


     class ChildSinCategoryViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iv_sincategory;
        private final TextView tv_sincategory_name;
        private final TextView tv_sincategory_price;

        public ChildSinCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_sincategory = itemView.findViewById(R.id.iv_sincategory);
            tv_sincategory_name = itemView.findViewById(R.id.tv_sincategory_name);
            tv_sincategory_price = itemView.findViewById(R.id.tv_sincategory_price);
        }
    }
}
