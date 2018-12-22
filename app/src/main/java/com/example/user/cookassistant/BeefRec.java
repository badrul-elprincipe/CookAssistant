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

public class BeefRec extends AppCompatActivity {

    String bd;

    ListView list;
    ArrayList<String> item;
    ArrayAdapter<String> ia;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beef_rec);
        Intent beef=getIntent();
        bd=beef.getExtras().getString("RECB");



        list=(ListView) findViewById(R.id.l1);
        item=new ArrayList<String>();
        ia=new ArrayAdapter<String>(BeefRec.this,android.R.layout.simple_list_item_1,item);
        item.add("Beef Burger");
        item.add("Beef Steak");
        list.setAdapter(ia);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                if(item.get(i).equals("Beef Burger")){

                        Intent bb=new Intent(BeefRec.this,Bb.class);
                        bb.putExtra("Json",bd);
                        startActivity(bb);



                }
                else {

                        Intent bs=new Intent(BeefRec.this,Bs.class);
                        bs.putExtra("Json",bd);
                        startActivity(bs);



                }
            }
        });


    }


}
