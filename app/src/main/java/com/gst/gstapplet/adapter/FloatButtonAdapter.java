package com.gst.gstapplet.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.gst.gstapplet.R;
import com.gst.gstapplet.databinding.FloatButtonItemBinding;
import com.gst.gstapplet.retrofit.bean.RcsInfoBean;

import java.util.List;

public class FloatButtonAdapter extends RecyclerView.Adapter<FloatButtonAdapter.FloatButtonViewHolder> {
    private List<RcsInfoBean.Button> list;

    @NonNull
    @Override
    public FloatButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FloatButtonItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.float_button_item, parent, false);
        return new FloatButtonViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FloatButtonViewHolder holder, int position) {
        holder.bindData(list.get(position));
    }


    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        else return 0;
    }


    class FloatButtonViewHolder extends RecyclerView.ViewHolder {
        FloatButtonItemBinding mBinding;

        public FloatButtonViewHolder(@NonNull View itemView, FloatButtonItemBinding binding) {
            super(itemView);
            this.mBinding = binding;
        }

        public void bindData(RcsInfoBean.Button button) {
            mBinding.setItem(button);
        }

    }

    public void setList(List<RcsInfoBean.Button> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
