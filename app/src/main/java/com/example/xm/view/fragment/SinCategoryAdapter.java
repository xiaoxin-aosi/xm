package com.example.xm.view.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.xm.R;
import com.example.xm.adapter.ChildSinCategoryAdapter;
import com.example.xm.net.Bean;

import java.util.ArrayList;
import java.util.List;

public class SinCategoryAdapter extends DelegateAdapter.Adapter {
    private final ArrayList<Bean.DataDTO.CategoryListDTO> cates;
    private final SingleLayoutHelper singleLayoutHelper;
    private final Context context;

    public SinCategoryAdapter(ArrayList<Bean.DataDTO.CategoryListDTO> cates, SingleLayoutHelper singleLayoutHelper, Context context) {
        this.cates = cates;
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new SinCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SinCategoryViewHolder viewHolder= (SinCategoryViewHolder) holder;
        Bean.DataDTO.CategoryListDTO categoryListDTO = cates.get(position);
        viewHolder.tv_name.setText(categoryListDTO.getName());
        viewHolder.rcy.setLayoutManager(new GridLayoutManager(context,2));
        List<Bean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList = categoryListDTO.getGoodsList();
        ChildSinCategoryAdapter childSinCategory = new ChildSinCategoryAdapter(context, goodsList);
        viewHolder.rcy.setAdapter(childSinCategory);
    }

    @Override
    public int getItemCount() {
        return cates.size();
    }
    class SinCategoryViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView rcy;
        private final TextView tv_name;

        public SinCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            rcy = itemView.findViewById(R.id.rcy);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }
}
