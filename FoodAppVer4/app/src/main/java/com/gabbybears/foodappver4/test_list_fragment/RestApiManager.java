package com.gabbybears.foodappver4.test_list_fragment;

import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Filippo-TheAppExpert on 9/2/2015.
 */
public class RestApiManager {

    private RestApi mFlowerApi;

    public RestApi getFlowerApi() {

        if(mFlowerApi == null) {
            GsonBuilder gson = new GsonBuilder();
            gson.registerTypeAdapter(String.class, new StringDesirializer());

            mFlowerApi = (RestApi) new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .setConverter(new GsonConverter(gson.create()))
                    .build()
                    .create(Rest_Item_Test.class);
        }
        return mFlowerApi;
    }

}
