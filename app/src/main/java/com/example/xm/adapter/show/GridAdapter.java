package com.example.xm.adapter.show;

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
import com.example.xm.bean.Bean;

import java.util.ArrayList;

public class GridAdapter extends DelegateAdapter.Adapter {
    private final GridLayoutHelper gridLayoutHelper;
    private ArrayList<Bean.DataDTO.ChannelDTO> types;
    private Context context;

    public GridAdapter(GridLayoutHelper gridLayoutHelper, ArrayList<Bean.DataDTO.ChannelDTO> types, Context context) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.types = types;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type, parent, false);
        return new GridAdapter.GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridAdapter.GridViewHolder viewHolder = (GridAdapter.GridViewHolder) holder;
        Bean.DataDTO.ChannelDTO channelDTO = types.get(position);
        viewHolder.tv_type.setText(channelDTO.getName());
        Glide.with(context).load(channelDTO.getIcon_url()).into(((GridViewHolder) holder).iv_type);
    }


    @Override
    public int getItemCount() {
        return types.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_type;
        private TextView tv_type;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_type = itemView.findViewById(R.id.iv_type);
            tv_type = itemView.findViewById(R.id.tv_type);
        }
    }
}
