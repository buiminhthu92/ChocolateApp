package com.gabbybears.retrofit19chayduoc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity {

    /*private static final String API_URL = "http://haiha711-001-site1.1tempurl.com/";
    private static final String API_KEY = "";*/

    TextView textView;
    TextView textView2;
    TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView5 = (TextView) findViewById(R.id.textView5);

        /*RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();*/
        /*IApiMethods methods = restAdapter.create(IApiMethods.class);
        Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                Curator curators = (Curator)o;
                textView.setText(curators.success + "\n\n");
                for (Curator.Dataset restaurent : curators.restaurent) {
                    textView2.setText(restaurent.longitudeX + "\n" +
                            " - " + restaurent.latitudeY + "\n");
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        };
        methods.getCurators(API_KEY, callback);*/
    }
}
