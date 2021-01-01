package com.example.xm.adapter.sub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.xm.R;

public class SubTextAdapter extends DelegateAdapter.Adapter {
    private SingleLayoutHelper singleLayoutHelper;

    public SubTextAdapter(SingleLayoutHelper singleLayoutHelper) {
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subtext, parent, false);
        return new SubTextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class SubTextViewHolder extends RecyclerView.ViewHolder{

        public SubTextViewHolder(@NonNull View itemView) {
            super(itemView);
            TextView tv_previous= itemView.findViewById(R.id.tv_previous);
            TextView tv_next = itemView.findViewById(R.id.tv_next);
        }
    }
}
