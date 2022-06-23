package com.example.weatherapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_cityID, btn_getWeatherByID, btn_getWeatherByName;
    EditText et_dataInput;
    ListView lv_weatherReport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_cityID = findViewById(R.id.btn_getCityID);
        btn_getWeatherByID = findViewById(R.id.btn_getWeatherByCityID);
        btn_getWeatherByName = findViewById(R.id.btn_getWeatherByCityName);

        et_dataInput = findViewById(R.id.et_dataInput);
        lv_weatherReport = findViewById(R.id.lv_WeatherReports);

        btn_cityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://api.openweathermap.org/data/2.5/weather?q=" +et_dataInput.getText().toString()+ "&appid=d43d289da8cc17b8164441817d7a8132";

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String cityID="";
                        try {
                            cityID = response.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        List<String> list = new ArrayList<>();
                        list.add("City ID:" + cityID);

                        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
                        lv_weatherReport.setAdapter(arrayAdapter);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Enter City Name!", Toast.LENGTH_SHORT).show();

                    }
                });

                queue.add(request);

            }
        });

        btn_getWeatherByID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://api.openweathermap.org/data/2.5/weather?id=" +et_dataInput.getText().toString()+ "&appid=d43d289da8cc17b8164441817d7a8132";

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String cityName="";
                        JSONObject main = new JSONObject();
                        String temp = "";
                        String pressure ="";
                        String humidity = "";
                        String temp_max ="";
                        JSONObject wind = new JSONObject();
                        String speed ="";
                        JSONObject sys = new JSONObject();
                        String country = "";

                        try {
                            cityName = response.getString("name");
                            main = response.getJSONObject("main");
                            temp = main.getString("temp");
                            pressure = main.getString("pressure");
                            humidity = main.getString("humidity");
                            temp_max = main.getString("temp_max");
                            wind = response.getJSONObject("wind");
                            speed = wind.getString("speed");
                            sys = response.getJSONObject("sys");
                            country = sys.getString("country");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        List<String> list = new ArrayList<>();
                        list.add("City Name:" + cityName);
                        list.add("Country: " +country);
                        list.add("Temperature: " + temp + " Kelvin");
                        list.add("Humidity: "+ humidity + "%");
                        list.add("Temperature High: "+ temp_max + " Kelvin");
                        list.add("Wind Speed: "+ speed + " Km/Hr");
                        list.add("Air Pressure: " + pressure + " mb");

                        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
                        lv_weatherReport.setAdapter(arrayAdapter);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Enter City ID!", Toast.LENGTH_SHORT).show();

                    }
                });

                queue.add(request);

            }
        });

        btn_getWeatherByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://api.openweathermap.org/data/2.5/weather?q=" +et_dataInput.getText().toString()+ "&appid=d43d289da8cc17b8164441817d7a8132";

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String cityName="";
                        JSONObject main = new JSONObject();
                        String temp = "";
                        String pressure ="";
                        String humidity = "";
                        String temp_max ="";
                        JSONObject wind = new JSONObject();
                        String speed ="";
                        JSONObject sys = new JSONObject();
                        String country = "";

                        try {
                            cityName = response.getString("name");
                            main = response.getJSONObject("main");
                            temp = main.getString("temp");
                            pressure = main.getString("pressure");
                            humidity = main.getString("humidity");
                            temp_max = main.getString("temp_max");
                            wind = response.getJSONObject("wind");
                            speed = wind.getString("speed");
                            sys = response.getJSONObject("sys");
                            country = sys.getString("country");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        List<String> list = new ArrayList<>();
                        list.add("City Name:" + cityName);
                        list.add("Country: " +country);
                        list.add("Temperature: " + temp + " Kelvin");
                        list.add("Humidity: "+ humidity + "%");
                        list.add("Temperature High: "+ temp_max + " Kelvin");
                        list.add("Wind Speed: "+ speed + " Km/Hr");
                        list.add("Air Pressure: " + pressure + " mb");

                        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
                        lv_weatherReport.setAdapter(arrayAdapter);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Enter City Name!", Toast.LENGTH_SHORT).show();

                    }
                });

                queue.add(request);
            }
        });
    }
}