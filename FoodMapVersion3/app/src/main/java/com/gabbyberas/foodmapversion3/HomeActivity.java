package com.gabbyberas.foodmapversion3;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

/**
 * Created by Android on 10/8/2015.
 */
public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;

    DrawerLayout drawerLayoutgesamt;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;

    ImageView ivanzeige;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        ivanzeige = (ImageView) findViewById(R.id.ivAnzeige);

        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        drawerLayoutgesamt = (DrawerLayout) findViewById(R.id.drawerlayoutgesamt);
        drawerToggle = new ActionBarDrawerToggle(HomeActivity.this,drawerLayoutgesamt,R.string.auf, R.string.zu);
        drawerLayoutgesamt.setDrawerListener(drawerToggle);

        navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.drawerViewItem1:{
                        ivanzeige.setImageResource(R.drawable.ic_mood_grey600_18dp);
                        break;
                    }

                    case R.id.drawerViewItem2:{
                        ivanzeige.setImageResource(R.drawable.ic_notifications_grey600_18dp);
                        break;
                    }

                    case R.id.drawerViewItem3:{
                        ivanzeige.setImageResource(R.drawable.ic_poll_grey600_18dp);
                        break;
                    }
                }

                drawerLayoutgesamt.closeDrawers();
                menuItem.setChecked(true);



                return false;
            }
        });


        ///////////WICHTIGE INFORMATION!!!!/////////// (Commit 16.05.2015)
        // Seit einem Android SDK Update wird das DrawerToggle nur noch angezeigt,
        // wenn ihr die folgenden 2 Zeilen Code schreibt, nachdem ihr dem Drawerlayout den DrawerListener gesetzt habt:

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