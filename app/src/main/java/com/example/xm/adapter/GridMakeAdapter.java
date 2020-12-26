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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.xm.R;
import com.example.xm.net.Bean;

import java.util.ArrayList;

public class GridMakeAdapter extends DelegateAdapter.Adapter {
    private final GridLayoutHelper gridLayoutHelper;
    private ArrayList<Bean.DataDTO.BrandListDTO> dtos;
    private final Context context;

    public GridMakeAdapter(GridLayoutHelper gridLayoutHelper, ArrayList<Bean.DataDTO.BrandListDTO> dtos, Context context) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.dtos = dtos;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_make, parent, false);
        return new GridMakeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridMakeViewHolder viewHolder= (GridMakeViewHolder) holder;
        Bean.DataDTO.BrandListDTO brandListDTO = dtos.get(position);
        Glide.with(context).load(brandListDTO.getNew_pic_url()).into(viewHolder.iv_image);
        viewHolder.tv1.setText(brandListDTO.getName());
        viewHolder.tv2.setText(brandListDTO.getFloor_price()+"元起");
    }

    @Override
    public int getItemCount() {
        return dtos.size();
    }
    class GridMakeViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv_image;
        private final TextView tv1;
        private final TextView tv2;

        public GridMakeViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_image = itemView.findViewById(R.id.iv_image);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
