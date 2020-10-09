package com.gst.gstapplet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import com.gst.gstapplet.BR;
import com.gst.gstapplet.R;
import com.gst.gstapplet.databinding.MsgTopbottomItemBinding;
import com.gst.gstapplet.retrofit.bean.RcsInfoBean;

import java.util.List;

import static com.gst.gstapplet.util.Constant.MULTI_CARD;
import static com.gst.gstapplet.util.Constant.SELF_MSG_TEXT;
import static com.gst.gstapplet.util.Constant.SINGLE_LEFT_TEXT_RIGHT_PHOTO;
import static com.gst.gstapplet.util.Constant.SINGLE_RIGHT_PHOTO_LEFT_TEXT;
import static com.gst.gstapplet.util.Constant.SINGLE_TOP_PHOTO_BOTTOM_TEXT;
import static com.gst.gstapplet.util.Constant.TEXT;


public class ChatBotDetailAdapter extends RecyclerView.Adapter<ChatBotDetailAdapter.ChatBotItemViewHolder> {
    private List<ChatBotItem> list;
    private Context context;

    public ChatBotDetailAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ChatBotItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
        return new ChatBotItemViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatBotItemViewHolder holder, int position) {
        if (list != null) {
            holder.bindData(list.get(position));
        }
    }

    public void setList(List<ChatBotItem> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        else return 0;
    }

    @Override
    public int getItemViewType(int position) {
        switch (list.get(position).viewType()) {
            case TEXT:
                return 0;
            case SINGLE_TOP_PHOTO_BOTTOM_TEXT:
                return R.layout.msg_topbottom_item;
            case SINGLE_LEFT_TEXT_RIGHT_PHOTO:
                return 2;
            case SINGLE_RIGHT_PHOTO_LEFT_TEXT:
                return 3;
            case MULTI_CARD:
                return 4;
            case SELF_MSG_TEXT:
                return R.layout.green_self_msg_item;
        }
        return super.getItemViewType(position);
    }

    //纯文本
    class ChatBotItemViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mBinding;

        public ChatBotItemViewHolder(@NonNull View itemView, ViewDataBinding binding) {
            super(itemView);
            this.mBinding = binding;
        }

        public void bindData(ChatBotItem item) {
            mBinding.setVariable(BR.item, item);
            RcsInfoBean rcsInfoBean = null;
            if (item instanceof RcsInfoBean)
                rcsInfoBean = (RcsInfoBean) item;
            switch (item.viewType()) {
                case TEXT:

                    break;
                case SINGLE_TOP_PHOTO_BOTTOM_TEXT:
                    MsgTopbottomItemBinding msgTopbottomItemBinding = (MsgTopbottomItemBinding) mBinding;
                    StaggeredGridLayoutManager staggeredGridLayoutManager = null;
                    if (rcsInfoBean.getMultipleCard().get(0).getBtnGroup().size() == 1)
                        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
                    else
                        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                    msgTopbottomItemBinding.rvCardButton.setLayoutManager(staggeredGridLayoutManager);
                    CardButtonAdapter topPBTCardBtnAdapter = new CardButtonAdapter(rcsInfoBean.getMultipleCard().get(0).getBtnGroup());
                    msgTopbottomItemBinding.rvCardButton.setAdapter(topPBTCardBtnAdapter);
                    break;
                case SINGLE_LEFT_TEXT_RIGHT_PHOTO:
                    break;
                case SINGLE_RIGHT_PHOTO_LEFT_TEXT:
                    break;
                case MULTI_CARD:
                    break;
                case SELF_MSG_TEXT:
                    break;
            }
        }
    }
}
