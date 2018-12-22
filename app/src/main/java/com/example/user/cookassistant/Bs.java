package com.example.user.cookassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Bs extends AppCompatActivity {


    String Json_data;
    ListView listView;
    NameAdapter nameAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bs);
        Intent i=getIntent();
        Json_data=i.getExtras().getString("Json");
        listView=(ListView) findViewById(R.id.listbs);
        nameAdapter=new NameAdapter(this);
        listView.setAdapter(nameAdapter);

        try {

            JSONArray jsonArray=new JSONArray(Json_data);
            int count=0;
            String recipee,time;
            while (count<jsonArray.length()){
                JSONObject jsonObject=jsonArray.getJSONObject(count);
                JSONObject object=jsonObject.getJSONObject("beefsteak");
                recipee=object.getString("recipe");

                time=object.getString("time");
                set steps=new set(recipee,time);
                nameAdapter.list.add(steps);

                count++;
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
