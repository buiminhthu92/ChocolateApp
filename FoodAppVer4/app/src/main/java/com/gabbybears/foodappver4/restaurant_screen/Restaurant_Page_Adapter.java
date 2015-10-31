package com.gabbybears.foodappver4.restaurant_screen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class Restaurant_Page_Adapter  extends FragmentStatePagerAdapter{

    private int TOTAL_TABS = 2;

    public Restaurant_Page_Adapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int index) {
        // TODO Auto-generated method stub
        switch (index) {
            case 0:
                return new Feed_Restaurant_Fragment();

            case 1:
                return new Photo_Restaurant_Fragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return TOTAL_TABS;
    }

}