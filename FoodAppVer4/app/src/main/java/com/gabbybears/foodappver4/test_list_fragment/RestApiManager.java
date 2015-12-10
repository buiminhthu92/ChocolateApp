package com.gabbybears.foodappver4.test_list_fragment;

import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Filippo-TheAppExpert on 9/2/2015.
 */
public class RestApiManager {

    private FlowerApi mFlowerApi;

    public FlowerApi getFlowerApi() {

        if(mFlowerApi == null) {
            GsonBuilder gson = new GsonBuilder();
            gson.registerTypeAdapter(String.class, new StringDesirializer());

            mFlowerApi = new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .setConverter(new GsonConverter(gson.create()))
                    .build()
                    .create(FlowerApi.class);
        }
        return mFlowerApi;
    }

}

