package com.example.tacademy.examplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ChannelAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    int[] IDS = {R.drawable.gallery_photo_1,
            R.drawable.gallery_photo_2,
            R.drawable.gallery_photo_3,
            R.drawable.gallery_photo_4,
            R.drawable.gallery_photo_5,
            R.drawable.gallery_photo_6,
            R.drawable.gallery_photo_7,
            R.drawable.gallery_photo_8
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        mAdapter = new ChannelAdapter();
        mAdapter.setOnClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ChannelData data = mAdapter.getItem(position);
                Toast.makeText(MainActivity.this, "data" + data.title, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(mAdapter);

//        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        initData();
    }

    private void initData() {
        Random r = new Random();
        for (int i = 0; i < 8; i++) {
            ChannelData data = new ChannelData();
            data.icon = getResources().getDrawable(IDS[i%IDS.length]);
            data.title = "item " + i;
            mAdapter.add(data);
        }
    }
}
