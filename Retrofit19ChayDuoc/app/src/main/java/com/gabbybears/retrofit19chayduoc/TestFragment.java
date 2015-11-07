package com.gabbybears.retrofit19chayduoc;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Android on 11/7/2015.
 */
public class TestFragment extends Fragment {

    TextView textView3;
    TextView textView4;
    Button btn1;

    private static final String API_URL = "http://haiha711-001-site1.1tempurl.com/";
    private static final String API_KEY = "";

    private String curText  = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        textView3 = (TextView) view.findViewById(R.id.textView3);
        textView4 = (TextView) view.findViewById(R.id.textView4);
        btn1 = (Button) view.findViewById(R.id.Btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "OK", Toast.LENGTH_SHORT).show();

                RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();
        IApiMethods methods = restAdapter.create(IApiMethods.class);
        Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                Curator curators = (Curator)o;
                textView3.setText(curators.success + "\n\n");
                for (Curator.Dataset restaurent : curators.restaurent) {
                    /*textView4.setText(restaurent.longitudeX + "\n" +
                            " - " + restaurent.latitudeY + "\n");*/

                    curText = restaurent.longitudeX + ", " + restaurent.latitudeY + "\n";

                    Log.d("TOA_DO", restaurent.longitudeX + ", " + restaurent.latitudeY);
                }
                textView4.setText(curText);
                Log.d("TEXT", curText);
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        };
        methods.getCurators(API_KEY, callback);
            }
        });

        return view;
    }

}
