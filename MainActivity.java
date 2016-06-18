package com.example.computer17.jsonparse;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView output = (TextView) findViewById(R.id.textView1);

        String strJson = "{\"Student\":[{\"id\": \"01\",\"name\": \"Pradeep\",\"DOB \": \"16 Feb 1992\"},{\"id\": \"02\",\"name\": \"Rakesh\",\"DOB\": \"9 sept 1995\"},{\"id\": \"03\",\"name\": \"Aarav\",\"DOB\": \"6 sept 2000\"}]}";
        String data = "";
        try {
            JSONObject  jsonRootObject;
            jsonRootObject = new JSONObject(strJson);

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.optJSONArray("Student");

            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = Integer.parseInt(jsonObject.optString("id").toString());
                String name = jsonObject.optString("name").toString();
                String DOB = jsonObject.optString("DOB").toString();
                data += "Student Number "+(i+1)+" : \n id= "+ id +" \n Student Name= "+ name +" \n Date Of Birth = "+ DOB +" \n\n\n\n ";
            }
            output.setText(data);
        } catch (JSONException e) {e.printStackTrace();}
    }
}
