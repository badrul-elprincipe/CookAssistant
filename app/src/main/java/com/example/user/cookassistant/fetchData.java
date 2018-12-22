package com.example.user.cookassistant;

import android.os.AsyncTask;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by user on 3/21/2018.
 */

public class fetchData extends AsyncTask<Void,Void,Void>{

    String data="";

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url=new URL("https://api.myjson.com/bins/11jczn");
            HttpsURLConnection httpURLConnection= (HttpsURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

            String br="";
            while (br!=null){
                br=bufferedReader.readLine();
                data=data+br;

            }
            JSONArray JA=new JSONArray(data);
            //for (int i=0;i<JA.length();i++){
            //JSONObject JO= (JSONObject) JA.get(i);
            //singleParsed=JO.get("name").toString()+"\n"+
            // JO.get("location").toString()+"\n";//+
            //JO.get("latitude").toString()+"\n"+
            //JO.get("longitude").toString()+"\n";
            //dataParsed=dataParsed+singleParsed;

            //}



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.info=this.data;


    }
}
