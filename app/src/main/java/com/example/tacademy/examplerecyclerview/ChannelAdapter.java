package com.example.tacademy.examplerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-02-09.
 */
public class ChannelAdapter extends RecyclerView.Adapter<ChannelViewHolder> implements OnItemClickListener {

    List<ChannelData> items = new ArrayList<ChannelData>();

    public void add(ChannelData data) {
        items.add(data);
        notifyDataSetChanged();
    }

    OnItemClickListener itemClickListener;
    public void setOnClickListener(OnItemClickListener listener) {
        itemClickListener = listener;
    }

    @Override
    public void onItemClick(View view, int position) {
        if (itemClickListener != null) {
            itemClickListener.onItemClick(view, position);
        }
    }

    @Override
    public ChannelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_item, parent, false);
        ChannelViewHolder holder = new ChannelViewHolder(view);
        holder.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(ChannelViewHolder holder, int position) {
        holder.setData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public ChannelData getItem (int position) {
        if (position < 0 || position >= items.size()) return null;

        return items.get(position);
    }

}
