package com.bsalponia.instrumentedtestapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bsalponia.instrumentedtestapp.R;
import com.bsalponia.instrumentedtestapp.model.Item;

import java.util.ArrayList;

public class CountListAdapter extends ArrayAdapter<Item> {

    private Context context;
    private int resource;
    private ArrayList<Item> list;

    public CountListAdapter(@NonNull Context context, int resource, ArrayList<Item> list) {
        super(context, resource, list);

        this.context= context;
        this.resource= resource;
        this.list= list;
    }

    static class ViewHolder{
        TextView txtCount;
        TextView txtDate;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        Item item= getItem(position);

        if(convertView== null){

            LayoutInflater inflater= ((Activity)context).getLayoutInflater();
            convertView= inflater.inflate(resource, parent, false);
            viewHolder= new ViewHolder();

            viewHolder.txtCount= convertView.findViewById(R.id.txtCount);
            viewHolder.txtDate= convertView.findViewById(R.id.txtDate);

            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder)convertView.getTag();
        }

        viewHolder.txtCount.setText(""+item.getCount());
        viewHolder.txtDate.setText(item.getDate());
        return convertView;
    }
}
