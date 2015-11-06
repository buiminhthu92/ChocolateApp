package com.gabbybears.retrofitlearn;


import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface CarApi {

    @GET("/get_1_tag.php?tagId={numId}")
    Call<Car> simpleGet(@Path("numId") String num);
}
