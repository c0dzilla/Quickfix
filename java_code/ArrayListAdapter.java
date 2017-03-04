package com.example.nikhilkaushik.quickfix;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ArrayListAdapter extends ArrayAdapter<Request> {
    public ArrayListAdapter(Activity context, ArrayList<Request> listItems) {
        super(context, 0, listItems);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.listitem, parent, false);
        }
        final Request currentNotif = getItem(position);
        TextView titledisplay = (TextView) listItemView.findViewById(R.id.textView13);
        TextView datedisplay = (TextView) listItemView.findViewById(R.id.textView14);
        TextView briefdisplay = (TextView) listItemView.findViewById(R.id.textView15);

        titledisplay.setText(currentNotif.getTitle());
        datedisplay.setText(currentNotif.getDate());
        briefdisplay.setText(currentNotif.getBrief());


        return listItemView;

    }
}

