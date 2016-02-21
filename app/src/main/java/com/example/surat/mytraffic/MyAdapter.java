package com.example.surat.mytraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.surat.mytraffic.R.id.textView2;

/**
 * Created by loy on 21-Feb-16.
 */
public class MyAdapter extends BaseAdapter{
    // Explicit
    private Context context;

    private int[] iconInts;
    private String[] titleStrings, detailShortString;

    public MyAdapter(Context context, int[] iconInts, String[] titleStrings, String[] detailShortString) {
        this.context = context;
        this.iconInts = iconInts;
        this.titleStrings = titleStrings;
        this.detailShortString = detailShortString;
    }// Constructor


    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//เปิด service
        View view = layoutInflater.inflate(R.layout.my_listview,parent,false);

        // About Icon
        ImageView iconImageView = (ImageView) view.findViewById(R.id.imageView);
        iconImageView.setImageResource(iconInts[position]);

        // About Title
        TextView titleTextView = (TextView) view.findViewById(textView2);
        titleTextView.setText(titleStrings[position]);

        //About Detail
        TextView detailTextView = (TextView) view.findViewById(R.id.textView3);
        detailTextView.setText(detailShortString[position]);

        return view;
    }
}// Main Class
