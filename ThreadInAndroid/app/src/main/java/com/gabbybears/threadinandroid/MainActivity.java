package com.gabbybears.threadinandroid;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;


public class MainActivity extends ActionBarActivity {

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            TextView myText = (TextView) findViewById(R.id.myText);
            myText.setText("Nice Jobs!");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBuckyButton(View view) {

        Runnable r = new Runnable() {
            long futureTime = System.currentTimeMillis() + 10000;
            @Override
            public void run() {
                while (System.currentTimeMillis() < futureTime) {
                    synchronized (this) {
                        try {
                            wait(futureTime - System.currentTimeMillis());
                        }
                        catch (Exception e) {

                        }
                    }
                }
                handler.sendEmptyMessage(0);
            }
        };

        Thread myThread = new Thread(r);
        myThread.start();
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

        return super.onOptionsItemSelected(item);
    }
}
