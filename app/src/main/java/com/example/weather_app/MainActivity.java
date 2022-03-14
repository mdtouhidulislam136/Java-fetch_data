package com.example.weather_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

// Activity represents more or less a screen within an android app
public class MainActivity extends AppCompatActivity {
    private RequestQueue queue;
    String url = "https://api.openweathermap.org/data/2.5/weather?q=tampere&units=metric&appid=a8a71fbc9440ced14b8e7ab79837b738";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // on create method sets up the GUI
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // instantiate the request queue
        queue = Volley.newRequestQueue(this);
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
        // make request to open weather api
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    // this is the callback for successful response
                    // show the network response within an toast
                    Toast.makeText(this, response, Toast.LENGTH_LONG).show();

                    // 1. parse the data from the weather JSON object
                    parseJsonAndUpdateUI(response);

                }, error -> {
                    // this is the conback whenever sothething went wrong with fetch
                     Toast.makeText(this, "Some error!", Toast.LENGTH_LONG).show();
                }

        );

        //2. send the request by adding it to the queue
        queue.add(stringRequest);


    }

    private void parseJsonAndUpdateUI(String response) {

        String weatherDescription = "Cloudy";
        double temperature = -20;
        double windSpeed = 5 ;
        // parse the data from response
        // 1. convert the response to json object

        try {
            JSONObject weather = new JSONObject(response);
           temperature = weather.getJSONObject("main").getDouble("temp");
           weatherDescription = weather.getJSONArray("weather").getJSONObject(0).getString("main");
           windSpeed = weather.getJSONObject("wind").getDouble("speed");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // we want to update these on the screen

        TextView weatherDescriptionTextView = findViewById(R.id.textViewWeatherDescription);
        weatherDescriptionTextView.setText(weatherDescription);


        TextView temperatureTextView = findViewById(R.id.textViewTemperature);
        temperatureTextView.setText("" +  temperature + "C");


        TextView WindSpeedTextView = findViewById(R.id.textViewWindSpeed);
        WindSpeedTextView.setText("" + windSpeed + "m/s");

    }
}





