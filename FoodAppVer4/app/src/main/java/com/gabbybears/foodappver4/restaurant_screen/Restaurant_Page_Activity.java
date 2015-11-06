package com.gabbybears.foodappver4.restaurant_screen;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.gabbybears.foodappver4.R;
import com.gabbybears.foodappver4.profile_screen.Profile_Fragment_Adapter;
import com.gabbybears.foodappver4.restaurant_screen.Restaurant_Fragment_Adapter;

/**
 * Created by Android on 10/17/2015.
 */
public class Restaurant_Page_Activity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_page_activity);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.restPageView, new Restaurant_Fragment_Adapter());
        transaction.commit();
    }
}
