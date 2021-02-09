package com.example.classactivity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private Button button_go;

    private static final String api_url="https://api.openweathermap.org/data/2.5/forecast?q=";
    private static final String key="&appid=1d212675bfe07dc4807e300c3bda43d4";
    private static final String units="&units=imperial";
    private static AsyncHttpClient client = new AsyncHttpClient();

    // private String city;
    // private String constructed_url;
    private EditText editText_city;
    // private ArrayList<WeatherData> weatherDataList = new ArrayList<>();
    private ArrayList<String> times = new ArrayList<>();
    private ArrayList<String> descriptions = new ArrayList<>();
    private ArrayList<String> temps = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_go = findViewById(R.id.button_go);
        editText_city = findViewById(R.id.editText_city);

        button_go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // handle what happens after button is clicked
                launchNextActivity(v);
            }
        });
    }

    private void launchNextActivity(View v) {

        // get text input
        String city = editText_city.getText().toString();
        String constructed_url = api_url+city+key+units;

        // set the header because of the api endpoint
        client.addHeader("Accept", "application/json");
        // send a get request to the api url
        client.get(constructed_url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                // when you get a 200 status code
                Log.d("api response", new String(responseBody));

                try {
                    JSONObject json = new JSONObject(new String(responseBody));
                    JSONObject city = json.getJSONObject("city");
                    JSONArray list = json.getJSONArray("list");

                    // System.out.println(list.getJSONObject(1));

                    for (int i = 0; i < list.length(); i++) {
                        String time = list.getJSONObject(i).getString("dt_txt");
                        JSONArray weather = list.getJSONObject(i).getJSONArray("weather");
                        String description = weather.getJSONObject(0).getString("description");
                        String temp = list.getJSONObject(i).getJSONObject("main").getString("feels_like");
                        // System.out.println(temp);
                        WeatherData data = new WeatherData(time, description, temp);
                        // System.out.println(weatherData.toString());
                        times.add(time);
                        descriptions.add(description);
                        temps.add(temp);
                        // weatherDataList.add(data);
                    }


                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    // add weather information into the intent
                    intent.putExtra("city", city.getString("name")+", ");
                    intent.putExtra("country", city.getString("country"));
                    // intent.putExtra("dataList", weatherDataList);
                    intent.putExtra("times", times);
                    intent.putExtra("descriptions", descriptions);
                    intent.putExtra("temps", temps);


                    startActivity(intent);

                } catch (JSONException e) {
                    e.printStackTrace();

                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                // when you get a 400-499 status code
                // implement String that says "No city found."
                Log.e("api error", new String(responseBody));

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // no city found
                intent.putExtra("error", "No city found");

                startActivity(intent);
            }
        });
    }
}