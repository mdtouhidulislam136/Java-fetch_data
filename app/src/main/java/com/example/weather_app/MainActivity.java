package com.example.weather_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// Activity represents more or less a screen within an android app
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // on create method sets up the GUI
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openForecast(View view) {
        // open forecast button click handler in Java
        // 1. Create an intent for opening ForecastActivity
        Intent intent = new Intent(this, ForecastActivity.class);

        //2. send some data to other activity with the INTENT
        //PARAMETERS: KEY FOR THE DATA AND VALUE FOR THE DATA

        intent.putExtra("CITY_NAME", "TAMPERE");
        //3. Start the activity through the intent
        startActivity(intent);
    }

    public void updateWeather(View view) {
        // fetch the weather from some weather API providing server
        // let's now just update some random data on the display

        String weatherDescription = "Cloudy";
        float temperature = (float) (Math.random() * 20);
        float windSpeed = 2.0f;
        // we want to update these on the screen

        TextView weatherDescriptionTextView = findViewById(R.id.textViewWeatherDescription);
        weatherDescriptionTextView.setText(weatherDescription);


        TextView temperatureTextView = findViewById(R.id.textViewTemperature);
        temperatureTextView.setText("" +  temperature + "C");


        TextView WindSpeedTextView = findViewById(R.id.textViewWindSpeed);
        WindSpeedTextView.setText("" + windSpeed + "m/s");

    }
}





