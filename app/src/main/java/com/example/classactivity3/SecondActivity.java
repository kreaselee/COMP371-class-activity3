package com.example.classactivity3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<WeatherData> weatherDataList;
    private RecyclerView recyclerView;
    private TextView textView_city;
    private TextView textView_country;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // look up views by id
        recyclerView = findViewById(R.id.recyclerView_weatherData);
        textView_city = findViewById(R.id.textView_city);
        textView_country = findViewById(R.id.textView_country);
        // create new ArrayList
        weatherDataList = new ArrayList<>();

        // unpack the intent
        Intent intent = getIntent();
        textView_city.setText(intent.getStringExtra("city"));
        textView_country.setText(intent.getStringExtra("country"));

        // add weather data from intent to weatherDataList
        int listSize = intent.getStringArrayListExtra("times").size();
        for (int i = 0; i < listSize; i++) {
            String time = intent.getStringArrayListExtra("times").get(i);
            String description = intent.getStringArrayListExtra("descriptions").get(i);
            String temp = intent.getStringArrayListExtra("temps").get(i);
            WeatherData weatherData = new WeatherData(time, description, temp);
            // System.out.println(weatherData.getTime());
            weatherDataList.add(weatherData);
        }



    }
}
