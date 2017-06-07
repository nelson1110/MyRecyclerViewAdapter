package com.cnyanglao.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TestAdapter mAdapter = new TestAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(mAdapter);

        ArrayList<String> data = new ArrayList<>();
        for (int i = 100; i > 0; i--) {
            data.add(i+"test");
        }

        mAdapter.setData(data);
    }


}
