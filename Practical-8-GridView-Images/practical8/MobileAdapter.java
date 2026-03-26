package com.example.practical8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MobileAdapter extends BaseAdapter {

    private Context context;
    private String[] mobileNames;
    private int[] mobileImages;

    public MobileAdapter(Context context, String[] mobileNames, int[] mobileImages) {
        this.context = context;
        this.mobileNames = mobileNames;
        this.mobileImages = mobileImages;
    }

    @Override
    public int getCount() {
        return mobileNames.length;
    }

    @Override
    public Object getItem(int position) {
        return mobileNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textView);

        imageView.setImageResource(mobileImages[position]);
        textView.setText(mobileNames[position]);

        return convertView;
    }
}