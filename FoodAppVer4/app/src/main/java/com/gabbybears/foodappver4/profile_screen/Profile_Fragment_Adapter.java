package com.gabbybears.foodappver4.profile_screen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class Profile_Fragment_Adapter  extends FragmentStatePagerAdapter{

    private int TOTAL_TABS = 3;

    public Profile_Fragment_Adapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int index) {
        // TODO Auto-generated method stub
        switch (index) {
            case 0:
                return new About_User_Fragment();

            case 1:
                return new Feed_User_Fragment();

            case 2:
                return new Photo_User_Fragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return TOTAL_TABS;
    }

}