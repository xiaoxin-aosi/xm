package com.example.xm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.xm.R;
import com.example.xm.adapter.ChildSinToplistAdapter;
import com.example.xm.net.Bean;

import java.util.ArrayList;

public class SinToplistAdapter extends DelegateAdapter.Adapter {
    private final ArrayList<Bean.DataDTO.TopicListDTO> tops;
    private final SingleLayoutHelper singleLayoutHelper;
    private Context context;

    public SinToplistAdapter(ArrayList<Bean.DataDTO.TopicListDTO> tops, SingleLayoutHelper singleLayoutHelper, Context context) {
        this.tops = tops;
        this.singleLayoutHelper = singleLayoutHelper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sintop, parent, false);
        return new SinTopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SinTopViewHolder viewHolder= (SinTopViewHolder) holder;
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        viewHolder.rcy.setLayoutManager(linearLayoutManager);
        ChildSinToplistAdapter childSinToplistAdapter = new ChildSinToplistAdapter(tops, context);
        viewHolder.rcy.setAdapter(childSinToplistAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class SinTopViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView rcy;

        public SinTopViewHolder(@NonNull View itemView) {
            super(itemView);
            rcy = itemView.findViewById(R.id.rcy);
        }
    }
}
