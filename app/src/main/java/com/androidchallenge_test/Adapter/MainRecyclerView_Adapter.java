package com.androidchallenge_test.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidchallenge_test.R;
import com.androidchallenge_test.Utils.List_DataModel;

import java.util.ArrayList;

public class MainRecyclerView_Adapter extends RecyclerView.Adapter<MainRecyclerView_Adapter.ViewHolder> {

    Context context;
    int resource;
    ArrayList<List_DataModel> locList;
    private LayoutInflater mInflater;

    public MainRecyclerView_Adapter(Context c, int resource, ArrayList<List_DataModel> locList) {
        this.context = c;
        this.resource = resource;
        this.locList = locList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        ViewHolder rcv = new ViewHolder(layoutView);

        return rcv;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.name.setText(locList.get(position).getAddressName());

    }

    @Override
    public int getItemCount() {
        return locList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.listitem_name_tv);

        }
    }
}
