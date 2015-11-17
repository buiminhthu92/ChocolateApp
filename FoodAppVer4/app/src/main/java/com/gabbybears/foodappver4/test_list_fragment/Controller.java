package com.gabbybears.foodappver4.test_list_fragment;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Filippo-TheAppExpert on 9/2/2015.
 */
public class Controller {

    private static final String TAG = Controller.class.getSimpleName();
    private FlowerCallbackListener mListener;
    private RestApiManager mApiManager;

    public Controller(FlowerCallbackListener listener) {
        mListener = listener;
        mApiManager = new RestApiManager();
    }

    public void startFetching() {
        mApiManager.getFlowerApi().getFlowers(new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                Log.d(TAG, "JSON :: " + s);

                try {
                    JSONArray array = new JSONArray(s);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);

                        Rest_Item_Test flower = new Rest_Item_Test.Builder()
                                .setNameRest(object.getString("restName"))
                                .setAddressRest(object.getString("address"))
                                .setNameTagRest(object.getString("tagName"))
                                .setLatitude(object.getDouble("latitudeY"))
                                .setLongtitude(object.getDouble("longitudeX"))
                                .setNameCoverRest(object.getString("imageName"))
                                .build();

                        mListener.onFetchProgress(flower);

                    }

                } catch (JSONException e) {
                    mListener.onFetchFailed();
                }


                mListener.onFetchComplete();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "Error :: " + error.getMessage());
                mListener.onFetchComplete();
            }
        });
    }

    public interface FlowerCallbackListener {

        void onFetchStart();
        void onFetchProgress(Rest_Item_Test flower);
        void onFetchProgress(List<Rest_Item_Test> flowerList);
        void onFetchComplete();
        void onFetchFailed();
    }
}

