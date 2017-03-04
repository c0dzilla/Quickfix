package com.example.nikhilkaushik.quickfix;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;



/**
 * Created by Nikhil Kaushik on 2/7/2017.
 */

public class ArrayListAdapter1 extends ArrayAdapter<allrequest> {

    public ArrayListAdapter1(Activity context, ArrayList<allrequest> listItems) {
        super(context, 0, listItems);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.listitem1, parent, false);
        }
        final allrequest currentNotif = getItem(position);
        TextView titledisplay1 = (TextView) listItemView.findViewById(R.id.textView4);
        TextView datedisplay1 = (TextView) listItemView.findViewById(R.id.textView5);

        Button button_open=(Button)listItemView.findViewById(R.id.button9);

        titledisplay1.setText(currentNotif.getTitle());
        datedisplay1.setText(currentNotif.getDate());


        button_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in= new Intent(view.getContext(), Main7Activity.class);
                in.putExtra("date",currentNotif.getDate());
                in.putExtra("title",currentNotif.getTitle());
                in.putExtra("description",currentNotif.getBrief());
                in.putExtra("address",currentNotif.getAddress());
                in.putExtra("id",Integer.toString(currentNotif.getId()));
                view.getContext().startActivity(in);
            }
        });
        return listItemView;

    }

}
