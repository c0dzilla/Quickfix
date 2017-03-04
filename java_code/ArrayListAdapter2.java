package com.example.nikhilkaushik.quickfix;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by Nikhil Kaushik on 2/7/2017.
 */

public class ArrayListAdapter2 extends ArrayAdapter<Messages> {

public ArrayListAdapter2(Activity context, ArrayList<Messages> listItems) {
        super(context, 0, listItems);
        }

@NonNull
@Override
public View getView(int position, View convertView, @NonNull ViewGroup parent){
        View listItemView=convertView;
        if(listItemView==null){
        listItemView= LayoutInflater.from(getContext()).inflate(R.layout.listitem1,parent,false);
        }
final Messages currentNotif=getItem(position);
    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getContext());

    mBuilder.setSmallIcon(R.drawable.logo);
    mBuilder.setContentTitle(currentNotif.getTitle());
    mBuilder.setContentText("Your request is accepted by"+currentNotif.getAcc_email());
    NotificationManager mNotificationManager = (NotificationManager)getContext().getSystemService(Context.NOTIFICATION_SERVICE);

// notificationID allows you to update the notification later on.
    mNotificationManager.notify(0, mBuilder.build());

    return listItemView;
        }


}