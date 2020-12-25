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
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.xm.R;
import com.example.xm.net.Bean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class SingleAdapter extends DelegateAdapter.Adapter {
    private final ArrayList<Bean.DataDTO.BannerDTO> list;
    private SingleLayoutHelper singleLayoutHelper;

    public SingleAdapter( ArrayList<Bean.DataDTO.BannerDTO> list, SingleLayoutHelper singleLayoutHelper) {
        this.list = list;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner, parent, false);
        return new BanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BanViewHolder viewHolder = (BanViewHolder) holder;
    viewHolder.banner.setImages(list)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Bean.DataDTO.BannerDTO data = (Bean.DataDTO.BannerDTO) path;
                        Glide.with(context).load(data.getImage_url()).into(imageView);
                    }
                })
                .start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class BanViewHolder extends RecyclerView.ViewHolder {

    private final Banner banner;

        public BanViewHolder(@NonNull View itemView) {
            super(itemView);
          banner = itemView.findViewById(R.id.banner);
        }
    }
}
