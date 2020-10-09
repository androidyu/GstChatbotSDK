package com.gst.gstapplet.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.gst.gstapplet.R;
import com.gst.gstapplet.databinding.RcsInfoListItemBinding;
import com.gst.gstapplet.listener.OnRcsInfoListClickListener;
import com.gst.gstapplet.retrofit.bean.RcsInfoBean;

import java.util.List;

public class ChatBotListAdapter extends RecyclerView.Adapter<ChatBotListAdapter.RcsInfoViewHolder> {
    private List<RcsInfoBean> list;
    OnRcsInfoListClickListener listener;

    public ChatBotListAdapter(OnRcsInfoListClickListener listener) {
        this.listener=listener;
    }

    @NonNull
    @Override
    public ChatBotListAdapter.RcsInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RcsInfoListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.rcs_info_list_item, parent, false);
        RcsInfoViewHolder rcsInfoViewHolder = new RcsInfoViewHolder(binding.getRoot());
        rcsInfoViewHolder.setBinding(binding);
        return rcsInfoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatBotListAdapter.RcsInfoViewHolder holder, int position) {
        if (list != null) {
            holder.bind(list.get(position),listener);
        }
    }

    public void setList(List<RcsInfoBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        else return 0;
    }

    class RcsInfoViewHolder extends RecyclerView.ViewHolder {
        private RcsInfoListItemBinding mBinding;

        public RcsInfoViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(@NonNull RcsInfoBean rcsInfoBean, OnRcsInfoListClickListener listener) {
            mBinding.setRcsInfoBean(rcsInfoBean);
            mBinding.executePendingBindings();
            mBinding.setListener(listener);
        }

        public void setBinding(RcsInfoListItemBinding binding) {
            this.mBinding = binding;
        }
    }


}
