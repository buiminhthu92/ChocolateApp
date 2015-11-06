package com.gabbybears.retrofitlearn.test_new_example;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.gabbybears.retrofitlearn.Car;
import com.gabbybears.retrofitlearn.CarApi;
import com.gabbybears.retrofitlearn.CarDes;
import com.gabbybears.retrofitlearn.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestClient.get().getWeather("California", new Callback<WeatherResponse>() {
            @Override
            public void success(WeatherResponse weatherResponse, Response response) {
                // success!
                Log.i("App", weatherResponse.getBase());
                Log.i("App", weatherResponse.getWeather().getMain());
                Log.i("App", weatherResponse.getWeather().getDescription());
                // you get the point...
            }

            @Override
            public void failure(RetrofitError error) {
                // something went wrong
            }
        });
    }
}