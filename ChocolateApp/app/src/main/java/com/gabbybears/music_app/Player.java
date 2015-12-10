package com.gabbybears.music_app;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Android on 12/7/2015.
 */
public class Player extends ActionBarActivity implements View.OnClickListener{

    static MediaPlayer mp;
    ArrayList<File> mySongs;
    int position;
    Uri u;
    Thread updateSeekBar;

    SeekBar sb;
    Button btPlay, btPv, btFB, btFF, btNxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        btPlay = (Button) findViewById(R.id.btPlay);
        btPv = (Button) findViewById(R.id.btPv);
        btFB = (Button) findViewById(R.id.btFB);
        btFF = (Button) findViewById(R.id.btFF);
        btNxt = (Button) findViewById(R.id.btNxt);
        sb = (SeekBar) findViewById(R.id.seekBar);

        btPlay.setOnClickListener(this);
        btPv.setOnClickListener(this);
        btFB.setOnClickListener(this);
        btFF.setOnClickListener(this);
        btNxt.setOnClickListener(this);

        updateSeekBar = new Thread() {
            @Override
            public void run() {
                int totalDuration = mp.getDuration();
                int currentPosition = 0;
                while (currentPosition < totalDuration) {
                    try {
                        sleep(500);
                        currentPosition = mp.getCurrentPosition();
                        sb.setProgress(currentPosition);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //super.run();
            }
        };

        if (mp != null) {
            mp.stop();
            mp.release();
        }

        Intent i = getIntent();
        Bundle b = i.getExtras();
        mySongs = (ArrayList) b.getParcelableArrayList("songlist");
        position = b.getInt("pos", 0);

        u = Uri.parse(mySongs.get(position).toString());
        mp = MediaPlayer.create(getApplicationContext(), u);
        mp.start();

        sb.setMax(mp.getDuration());

        updateSeekBar.start();

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mp.seekTo(seekBar.getProgress());
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btPlay:
                if (mp.isPlaying()) {
                    btPlay.setText("D");
                    mp.pause();
                }
                else {
                    btPlay.setText("C");
                    mp.start();
                }
                break;

            case R.id.btPv:
                mp.stop();
                mp.release();
                position = (position - 1) < 0 ? mySongs.size() - 1 : position - 1;
                u = Uri.parse(mySongs.get(position).toString());
                mp = MediaPlayer.create(getApplicationContext(), u);
                mp.start();
                sb.setMax(mp.getDuration());
                break;

            case R.id.btFB:
                mp.seekTo(mp.getCurrentPosition()-5000);
                break;

            case R.id.btFF:
                mp.seekTo(mp.getCurrentPosition()+5000);
                break;

            case R.id.btNxt:
                mp.stop();
                mp.release();
                position = (position + 1) % mySongs.size();
                u = Uri.parse(mySongs.get(position).toString());
                mp = MediaPlayer.create(getApplicationContext(), u);
                mp.start();
                sb.setMax(mp.getDuration());
                break;
        }
    }
}
