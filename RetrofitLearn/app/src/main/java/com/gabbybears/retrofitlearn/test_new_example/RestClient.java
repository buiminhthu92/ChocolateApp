package com.gabbybears.retrofitlearn.test_new_example;

import com.squareup.okhttp.OkHttpClient;

import retrofit.Retrofit;

public class RestClient {

    private static API REST_CLIENT;
    private static String ROOT =
            "http://api.openweathermap.org/data/2.5";

    static {
        setupRestClient();
    }

    private RestClient() {}

    public static API get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ROOT)
                .setClient(new OkClient(new OkHttpClient()))
                .builder.setLogLevel(Retrofit.LogLevel.FULL);

        Retrofit restAdapter = builder.build();
        REST_CLIENT = restAdapter.create(API.class);
    }
}
