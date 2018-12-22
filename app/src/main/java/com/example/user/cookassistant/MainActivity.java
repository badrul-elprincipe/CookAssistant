package com.example.user.cookassistant;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button ck;
    CheckBox c1;
    CheckBox c2;


    static String info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c1=(CheckBox)findViewById(R.id.checkBox);
        c2=(CheckBox)findViewById(R.id.checkBox2);






        ck=(Button)findViewById(R.id.ck1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c2.setChecked(false);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c1.setChecked(false);
            }
        });
        ck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchData process=new fetchData();
                process.execute();
                if(c1.isChecked()){

                    Intent beef=new Intent(MainActivity.this,BeefRec.class);
                    beef.putExtra("RECB",info.toString());

                    startActivity(beef);
                    c1.setChecked(false);


                }
                else if(c2.isChecked()){
                    Intent chick=new Intent(MainActivity.this,ChickRec.class);
                    chick.putExtra("RECC",info.toString());
                    startActivity(chick);
                    c2.setChecked(false);

                }
                else if (!(c1.isChecked())&&!(c2.isChecked())){
                    Toast.makeText(MainActivity.this,"Please Select First",Toast.LENGTH_LONG).show();
                }











            }
        });
















    }


}
