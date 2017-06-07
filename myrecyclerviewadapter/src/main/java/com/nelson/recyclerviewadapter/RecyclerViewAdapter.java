package com.nelson.recyclerviewadapter;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Niu on 2017/6/7.
 *
 */
@Keep
public abstract class RecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<T> mDatas = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return null;
        }
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(viewType,parent,false);

        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        onBind(holder.getView(),position,mDatas.get(position));
    }


    public abstract void onBind(View itemView, int position, T item);

    @Override
    public int getItemViewType(int position) {
        return getItemLayout(position);
    }

    @LayoutRes
    public abstract int getItemLayout(int position);

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

   protected static class ViewHolder extends RecyclerView.ViewHolder{

        private View mItemView;

        ViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
        }

        public View getView(){
            return mItemView;
        }
    }

    public void addAll(ArrayList<T> datas){
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public void setData(ArrayList<T> datas){
        mDatas.clear();
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public void add(T data){
        mDatas.add(data);
        notifyDataSetChanged();
    }

    public void add(int index , T data){
        mDatas.add(index,data);
        notifyDataSetChanged();
    }

    public ArrayList<T> getData(){
        return mDatas;
    }
}
