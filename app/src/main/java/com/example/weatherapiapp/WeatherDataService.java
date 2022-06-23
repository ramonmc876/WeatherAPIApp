package com.example.weatherapiapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class WeatherDataService {

    public static final String QUERY_FOR_CITY_ID = "https://api.openweathermap.org/data/2.5/weather?q=";
    public static final String API_KEY = "&appid=d43d289da8cc17b8164441817d7a8132";
    Context context;
    String cityID;

    public WeatherDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String CityID);
    }

    public void getCityID(String cityName, VolleyResponseListener volleyResponseListener) {

        String url = QUERY_FOR_CITY_ID + cityName + API_KEY;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                cityID="";
                try {
                    cityID = response.getString("id");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // this worked but didn't return the id number to MainActivity
                //Toast.makeText(context, "city ID is:" + cityID, Toast.LENGTH_SHORT).show();
                volleyResponseListener.onResponse(cityID);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(context, "Something wrong.", Toast.LENGTH_SHORT).show();
                volleyResponseListener.onError("something wrong");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);

        // returned a NULL. problem!
       // return cityID;

    }

//    public List<WeatherReportModel> getCityForecastByID(String cityID){
//
//    }
//
//    public List<WeatherReportModel> getCityForecastByName(String cityName){
//
//    }

}
