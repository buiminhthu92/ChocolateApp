package com.gabbybears.music_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView lv;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lvPlaylist);

        final ArrayList<File> mySongs = findSongs(Environment.getExternalStorageDirectory());
        items = new String[mySongs.size()];
        for (int i =0; i < mySongs.size(); i++) {
            items[i] = mySongs.get(i).getName().toString();

        }

        ArrayAdapter<String> adt = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, items);
        lv.setAdapter(adt);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                startActivity(new Intent(getApplicationContext(), Player.class).putExtra("pos", position)
                        .putExtra("songlist", mySongs));
            }
        });
    }

    public ArrayList<File> findSongs(File root){
        ArrayList<File> al = new ArrayList<File>();
        File[] files = root.listFiles();
        for (File singleFile : files) {
            if (singleFile.isDirectory() && !singleFile.isHidden()) {
                al.addAll(findSongs(singleFile));
            }
            else {
                if (singleFile.getName().endsWith(".mp3")) {
                    al.add(singleFile);
                }
            }
        }
        return al;
    }
}
