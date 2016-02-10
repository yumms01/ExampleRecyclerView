package com.example.tacademy.examplerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Tacademy on 2016-02-09.
 */
public class ChannelViewHolder extends RecyclerView.ViewHolder {
    ImageView iconView;
    TextView titleView;
    ChannelData data;

    public OnItemClickListener itemClickListener;
    public void setOnClickListener (OnItemClickListener listener) {
        itemClickListener = listener;
    }
    public ChannelViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(v, getAdapterPosition());
                }
            }
        });

        iconView = (ImageView)itemView.findViewById(R.id.image_icon);
        titleView = (TextView)itemView.findViewById(R.id.text_title);
    }

    public void setData(ChannelData data) {
        this.data = data;
        iconView.setImageDrawable(data.icon);
        titleView.setText(data.title);
    }
}
