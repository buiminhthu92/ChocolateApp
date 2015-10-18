package com.gabbybears.foodappver4.home_screen;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.gabbybears.foodappver4.R;
import com.gabbybears.foodappver4.fragments_screen.List_Page_Fragment;
import com.gabbybears.foodappver4.fragments_screen.Map_With_Tag_Fragment;
import com.gabbybears.foodappver4.fragments_screen.Request_Res_Fragment;

/**
 * Created by Android on 10/8/2015.
 */
public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;

    DrawerLayout drawerLayoutgesamt;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;

    ImageView ivanzeige;
    Fragment fragment = null;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        // ivanzeige = (ImageView) findViewById(R.id.ivAnzeige);

        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        drawerLayoutgesamt = (DrawerLayout) findViewById(R.id.drawerlayoutgesamt);
        drawerToggle = new ActionBarDrawerToggle(HomeActivity.this,drawerLayoutgesamt,R.string.auf, R.string.zu);
        drawerLayoutgesamt.setDrawerListener(drawerToggle);

        navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Fragment newFragment;

                switch (menuItem.getItemId()){

                    case R.id.drawerViewItem1:{
                        // ivanzeige.setImageResource(R.drawable.ic_mood_grey600_18dp);
                        fragment = new Map_With_Tag_Fragment();

                        break;
                    }

                    case R.id.drawerViewItem2:{
                        //ivanzeige.setImageResource(R.drawable.ic_notifications_grey600_18dp);
                        fragment = new List_Page_Fragment();


                        break;
                    }

                    case R.id.drawerViewItem3:{
                        // ivanzeige.setImageResource(R.drawable.ic_poll_grey600_18dp);
                        fragment = new Request_Res_Fragment();

                        break;
                    }
                }

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.group, fragment);
                    transaction.commit();
                }

                drawerLayoutgesamt.closeDrawers();
                menuItem.setChecked(true);

                return false;
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(new Configuration());
    }
}