package com.example.xm.adapter;

import android.content.Context;
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

import java.util.ArrayList;

public class ChildSinToplistAdapter extends RecyclerView.Adapter {
    private final ArrayList<Bean.DataDTO.TopicListDTO> tops;
    private final Context context;

    public ChildSinToplistAdapter(ArrayList<Bean.DataDTO.TopicListDTO> tops, Context context) {
        this.tops = tops;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tops, parent, false);
        return new ChildSinTopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChildSinTopViewHolder viewHolder= (ChildSinTopViewHolder) holder;
        Bean.DataDTO.TopicListDTO topicListDTO = tops.get(position);
        Glide.with(context).load(topicListDTO.getItem_pic_url()).into(viewHolder.iv_tops);
        viewHolder.tv_tops_name.setText(topicListDTO.getTitle());
        viewHolder.tv_tops_price.setText("￥"+topicListDTO.getPrice_info());
        viewHolder.tv_tops_subtitle.setText(topicListDTO.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return tops.size();
    }
    class ChildSinTopViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_tops;
        private final TextView tv_tops_name;
        private final TextView tv_tops_price;
        private final TextView tv_tops_subtitle;

        public ChildSinTopViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_tops = itemView.findViewById(R.id.iv_tops);
            tv_tops_name = itemView.findViewById(R.id.tv_tops_name);
            tv_tops_price = itemView.findViewById(R.id.tv_tops_price);
            tv_tops_subtitle = itemView.findViewById(R.id.tv_tops_subtitle);
        }
    }
}
