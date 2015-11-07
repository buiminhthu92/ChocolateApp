package com.gabbybears.foodappver4.api_retrofit;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface IApiMethods {

    @GET("/get_all_rest.php")
    void getCurators(
            @Query("api_key") String key, Callback<Curator> cb
    );

    @GET("/get_1_rest.php?restId=1")
    void getCurators1(
            @Query("api_key") String key, Callback<Curator> cb
    );

    @GET("/get_1_rest.php?restId=2")
    void getCurators2(
            @Query("api_key") String key, Callback<Curator> cb
    );

    @GET("/get_1_rest.php?restId=3")
    void getCurators3(
            @Query("api_key") String key, Callback<Curator> cb
    );

    @GET("/get_1_rest.php?restId=4")
    void getCurators4(
            @Query("api_key") String key, Callback<Curator> cb
    );

    @GET("/get_1_rest.php?restId=5")
    void getCurators5(
            @Query("api_key") String key, Callback<Curator> cb
    );

    @GET("/get_1_rest.php?restId=6")
    void getCurators6(
            @Query("api_key") String key, Callback<Curator> cb
    );

    @GET("/get_1_rest.php?restId=7")
    void getCurators7(
            @Query("api_key") String key, Callback<Curator> cb
    );
}