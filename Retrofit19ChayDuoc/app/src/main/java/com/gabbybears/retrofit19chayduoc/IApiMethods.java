package com.gabbybears.retrofit19chayduoc;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface IApiMethods {

    @GET("/get_all_rest.php")
    void getCurators(
            @Query("api_key") String key, Callback<Curator> cb
    );
}