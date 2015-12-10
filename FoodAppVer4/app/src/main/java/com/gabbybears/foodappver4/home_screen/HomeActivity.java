package com.gabbybears.foodappver4.home_screen;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gabbybears.foodappver4.R;
import com.gabbybears.foodappver4.RoundImage;
import com.gabbybears.foodappver4.RoundedTransformation;
import com.gabbybears.foodappver4.feedback_email_screen.Feedback_Email_Fragment;
import com.gabbybears.foodappver4.find_by_distance_screen.Find_By_Distance_Fragment;
import com.gabbybears.foodappver4.friends_screen.Friends_Fragment_Adapter;
import com.gabbybears.foodappver4.notification_screen.Notification_Fragment;
import com.gabbybears.foodappver4.profile_screen.Profile_Fragment_Adapter;
import com.gabbybears.foodappver4.setting_screen.Setting_Fragment;
import com.gabbybears.foodappver4.start_screen.MainActivity;
import com.gabbybears.foodappver4.start_screen.MainFragment;
import com.squareup.picasso.Picasso;

/**
 * Created by Android on 10/8/2015.
 */
public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;

    DrawerLayout drawerLayoutgesamt;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;

    Fragment fragment = null;
    FragmentManager fragmentManager;

    ImageView icon;
    private ImageView avarUserImg;
    private TextView nameUser;

    private static RoundImage myAvarRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        avarUserImg = (ImageView) findViewById(R.id.imageUserAvar);
        nameUser = (TextView) findViewById(R.id.nameUser);

        Picasso.with(HomeActivity.this)
                .load(MainFragment.uriImgUser)
                .placeholder(R.drawable.default_img_user)
                .transform(new RoundedTransformation(50, 0))
                .into(avarUserImg);
        nameUser.setText(MainFragment.nameUser);

        /*BitmapDrawable drawable = (BitmapDrawable) avarUserImg.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        myAvarRound = new RoundImage(bitmap);
        avarUserImg.setImageDrawable(myAvarRound);*/

        fragmentManager = getSupportFragmentManager();
        fragment = new Map_With_Tag_Fragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.group, fragment);
        transaction.commit();

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

                        fragment = new Map_With_Tag_Fragment();

                        break;
                    }

                    case R.id.drawerViewItem2:{

                        fragment = new Find_By_Distance_Fragment();

                        break;
                    }

                    case R.id.drawerViewItem3:{

                        fragment = new Notification_Fragment();

                        break;
                    }

                    case R.id.drawerViewItem4:{

                        fragment = new Profile_Fragment_Adapter();

                        break;
                    }

                    case R.id.drawerViewItem5:{

                        fragment = new Friends_Fragment_Adapter();

                        break;
                    }

                    case R.id.drawerViewItem6:{

                        fragment = new Setting_Fragment();

                        break;
                    }

                    case R.id.drawerViewItem7:{

                        fragment = new Feedback_Email_Fragment();

                        break;
                    }

                    case R.id.drawerViewItem8:{

                        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                        startActivity(intent);

                        break;
                    }
                }

                drawerLayoutgesamt.closeDrawers();
                menuItem.setChecked(true);



                replaceFragment(fragment);

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
        /*if (id == R.id.action_settings) {
            return true;
        }*/

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

    //Replace fragment method
    private void replaceFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        String fragmentTag = backStateName;

        Log.d("NameFragment", fragmentTag);

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null){ //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.group, fragment, fragmentTag);
            //ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    public void ClickAvar(View v) {
        Toast.makeText(HomeActivity.this, "You click avar", Toast.LENGTH_SHORT).show();
        FragmentManager manager = getSupportFragmentManager();

        for(int i = 0; i < manager.getBackStackEntryCount(); ++i) {
            manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.group, new Notification_Fragment());
        ft.commit();

        drawerLayoutgesamt.closeDrawers();
    }
}