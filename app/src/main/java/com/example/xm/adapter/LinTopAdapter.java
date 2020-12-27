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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.xm.R;
import com.example.xm.net.Bean;

import java.util.ArrayList;

public class LinTopAdapter extends DelegateAdapter.Adapter {


    private final LinearLayoutHelper linearLayoutHelper;
    private final Context context;
    private final ArrayList<Bean.DataDTO.TopicListDTO> tops;

    public LinTopAdapter(LinearLayoutHelper linearLayoutHelper, Context context, ArrayList<Bean.DataDTO.TopicListDTO> tops) {

        this.linearLayoutHelper = linearLayoutHelper;
        this.context = context;
        this.tops = tops;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tops, parent, false);
        return new LinTopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LinTopViewHolder viewHolder= (LinTopViewHolder) holder;
        Bean.DataDTO.TopicListDTO topicListDTO = tops.get(position);
        Glide.with(context).load(topicListDTO.getItem_pic_url()).into(viewHolder.iv_tops);
        viewHolder.tv_tops_name.setText(topicListDTO.getTitle());
        viewHolder.tv_tops_price.setText("￥"+topicListDTO.getPrice_info()+"元起");
        viewHolder.tv_tops_subtitle.setText(topicListDTO.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return tops.size();
    }
    class LinTopViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_tops;
        private final TextView tv_tops_name;
        private final TextView tv_tops_price;
        private final TextView tv_tops_subtitle;

        public LinTopViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_tops = itemView.findViewById(R.id.iv_tops);
            tv_tops_name = itemView.findViewById(R.id.tv_tops_name);
            tv_tops_price = itemView.findViewById(R.id.tv_tops_price);
            tv_tops_subtitle = itemView.findViewById(R.id.tv_tops_subtitle);
        }
    }
}
