package com.gst.gstapplet.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.gst.gstapplet.R;
import com.gst.gstapplet.databinding.CardButtonItemBinding;
import com.gst.gstapplet.retrofit.bean.RcsInfoBean;

import java.util.List;

public class CardButtonAdapter extends RecyclerView.Adapter<CardButtonAdapter.CardButtonViewHolder> {
    private List<RcsInfoBean.Button> list;

    @NonNull
    @Override
    public CardButtonAdapter.CardButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardButtonItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.card_button_item, parent, false);
        return new CardButtonViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardButtonAdapter.CardButtonViewHolder holder, int position) {
        holder.bindData(list.get(position));
    }


    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        else return 0;
    }


    class CardButtonViewHolder extends RecyclerView.ViewHolder {
        CardButtonItemBinding mBinding;

        public CardButtonViewHolder(@NonNull View itemView, CardButtonItemBinding binding) {
            super(itemView);
            this.mBinding = binding;
        }

        public void bindData(RcsInfoBean.Button button) {
            mBinding.setItem(button);
        }

    }


    public CardButtonAdapter(List<RcsInfoBean.Button> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
