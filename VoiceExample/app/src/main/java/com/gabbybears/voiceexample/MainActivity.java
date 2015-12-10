package com.gabbybears.voiceexample;

import android.app.Activity;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener {

    Button btnVoice;
    ListView lvVoice;

    static final int check = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVoice = (Button) findViewById(R.id.btnVoice);
        lvVoice = (ListView) findViewById(R.id.lvVoice);

        btnVoice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak up son!");
        startActivityForResult(i, check);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == check && resultCode == RESULT_OK) {
            ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            lvVoice.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, results));
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
