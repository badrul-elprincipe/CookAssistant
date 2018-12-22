package com.example.user.cookassistant;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by user on 3/20/2018.
 */

public class NameAdapter extends BaseAdapter{

    ArrayList<set>list;
    Context c;
    NameAdapter(Context context){
        c=context;
        list=new ArrayList<set>();


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=layoutInflater.inflate(R.layout.reccf,parent,false);
        TextView pr=(TextView)row.findViewById(R.id.rec);
        final TextView tim=(TextView)row.findViewById(R.id.time);
        final Button alarm=(Button)row.findViewById(R.id.alarm1);

        set tmp=list.get(position);
        pr.setText(tmp.pro);
        tim.setText(tmp.time);
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long millisInF=Long.parseLong((String) tim.getText())*1000;
                long milliInterv=1000;
                //boolean timerun=false;



                new CountDownTimer(millisInF,milliInterv){
                    @Override
                    public void onTick(long l) {
                        tim.setText(""+l/1000);
                        alarm.setEnabled(false);


                    }

                    @Override
                    public void onFinish() {

                        alarm.setEnabled(false);
                        Intent intent=new Intent(c.getApplicationContext(),MyAlarm.class);
                        PendingIntent pendingIntent=PendingIntent.getBroadcast(c.getApplicationContext(),1,intent,0);
                        AlarmManager alarmManager=(AlarmManager) c.getSystemService(ALARM_SERVICE);
                        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),pendingIntent);
                        tim.setText("Done");




                    }
                }.start();




            }
        });

        return row;
    }
}
class set{
    String pro;
    String time;
    set(String pro,String time){
        this.pro=pro;
        this.time=time;
    }
}


