package com.gabbybears.foodappver4.profile_screen;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;

import com.gabbybears.foodappver4.R;

public class ProfileActivity extends ActionBarActivity implements android.support.v7.app.ActionBar.TabListener{

    private ViewPager tabsviewPager;
    private ActionBar mActionBar;
    private Profile_Fragment_Adapter mTabsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        tabsviewPager = (ViewPager) findViewById(R.id.tabspager);

        mTabsAdapter = new Profile_Fragment_Adapter(getSupportFragmentManager());

        tabsviewPager.setAdapter(mTabsAdapter);

        Tab friendstab = getSupportActionBar().newTab().setText("Friends").setTabListener(this);
        Tab publicprofiletab = getSupportActionBar().newTab().setText("Public").setTabListener(this);
        Tab communitytab = getSupportActionBar().newTab().setText("Community").setTabListener(this);

        getSupportActionBar().addTab(friendstab);
        getSupportActionBar().addTab(publicprofiletab);
        getSupportActionBar().addTab(communitytab);


        //This helps in providing swiping effect for v7 compat library
        tabsviewPager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                getSupportActionBar().setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });

    }

    @Override
    public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTabSelected(Tab selectedtab, FragmentTransaction arg1) {
        // TODO Auto-generated method stub
        tabsviewPager.setCurrentItem(selectedtab.getPosition()); //update tab position on tap
    }

    @Override
    public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }
}