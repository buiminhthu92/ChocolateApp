package com.gabbybears.retrofitlearn.test_new_example;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface API {

    @GET("/weather")
    void getWeather(@Query("q") String cityName,
                    Callback<WeatherResponse> callback);
}
