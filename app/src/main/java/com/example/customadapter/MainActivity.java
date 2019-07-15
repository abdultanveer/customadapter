package com.example.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String movie_title[]={"Kabali","Gabarsingh","Srimanthudu","Bahubali","A aa"};
    String img_urls[]={"http://bytecodetechnosolutions.com/Images/kabali.jpg",
            "http://bytecodetechnosolutions.com/Images/gabarsingh.jpg",
            "http://bytecodetechnosolutions.com/Images/srimanthudu.jpg",
            "http://bytecodetechnosolutions.com/Images/bahubali.jpg",
            "http://bytecodetechnosolutions.com/Images/a_aa.jpg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovieAdapter adapter = new MovieAdapter(movie_title,img_urls,this);
        ListView mListView = findViewById(R.id.customlistview);
        mListView.setAdapter(adapter);
    }
}
