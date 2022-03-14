package com.example.weather_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class ForecastActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);



        // READ     POSSIBLE intent data
        // if there is CITY_NAME, read it and put it on the screen
        // if string extra is not there, cityname string remains null

        String cityName = getIntent().getStringExtra("CITY_NAME");
        // let's put it on the screen
        TextView weatherForecastCityName = findViewById(R.id.textViewForecastCityName);
       // weatherForecastCityName.setText(cityName);
        if (cityName != null) {
            weatherForecastCityName.setText(cityName);

        }
        // if not, put something as default e.g. Dhaka
        else {
            weatherForecastCityName.setText("Dhaka");
        }
    }
}