package com.cnyanglao.myrecyclerview;

import android.view.View;
import android.widget.TextView;

import com.nelson.recyclerviewadapter.RecyclerViewAdapter;

/**
 * Created by Niu on 2017/6/7.
 */

public class TestAdapter extends RecyclerViewAdapter<String> {


    @Override
    public void onBind(View itemView, int position, String item) {
        TextView textView = (TextView) itemView.findViewById(R.id.text);
        textView.setText(item);
    }


    @Override
    public int getItemLayout(int position) {
        if(position % 2 == 0){
            return R.layout.item_type_a;
        }else {
            return R.layout.item_type_b;
        }

    }



}
