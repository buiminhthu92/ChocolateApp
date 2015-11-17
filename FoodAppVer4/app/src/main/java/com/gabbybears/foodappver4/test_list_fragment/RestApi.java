package com.gabbybears.foodappver4.test_list_fragment;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Filippo-TheAppExpert on 9/2/2015.
 */
public interface RestApi {

    @GET("/get_list_rest_info.php")
    void getFlowers(Callback<String> flowers);
}
