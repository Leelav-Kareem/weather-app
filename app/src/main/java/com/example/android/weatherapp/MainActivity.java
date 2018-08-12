package com.example.android.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView cityNameTextView=findViewById(R.id.city_name);
        TextView temperatureTextView=findViewById(R.id.temperature);
        TextView windSpeedTextView=findViewById(R.id.wind_speed);
        TextView humidityTextView=findViewById(R.id.humidity);


        try {
            JSONObject root= new JSONObject(JSON.json);

            //NAME

            String name=root.getString("name");
            cityNameTextView.setText(name);

            //temp & humidity
            JSONObject main=root.getJSONObject("main");
            String temperature=main.getString("temp");
            temperatureTextView.setText("Temperature: "+temperature+" C");

            String humidity=main.getString("humidity");
            humidityTextView.setText("Humidity: "+humidity);

            //speed
            JSONObject wind=root.getJSONObject("wind");
            String speed=wind.getString("speed");
            windSpeedTextView.setText("Wind speed: "+speed+" km/hr");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
