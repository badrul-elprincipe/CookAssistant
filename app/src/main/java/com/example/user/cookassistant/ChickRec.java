package com.example.user.cookassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChickRec extends AppCompatActivity {

    String cd;

    ListView list;
    ArrayList<String> item;
    ArrayAdapter<String> ia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chick_rec);
        Intent chick=getIntent();
        cd=chick.getExtras().getString("RECC");



        list=(ListView) findViewById(R.id.l1);
        item=new ArrayList<String>();
        ia=new ArrayAdapter<String>(ChickRec.this,android.R.layout.simple_list_item_1,item);
        item.add("Chicken Burger");
        item.add("Chicken Fry");
        list.setAdapter(ia);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                if(item.get(i).equals("Chicken Fry")){

                        Intent cf=new Intent(ChickRec.this,Cf.class);
                        cf.putExtra("Json",cd);
                        startActivity(cf);



                }
                else{

                        Intent cb=new Intent(ChickRec.this,Cb.class);
                        cb.putExtra("Json",cd);
                        startActivity(cb);




                }
            }
        });


    }


}
