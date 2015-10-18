package com.gabbybears.fragmentexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
    }

    public void AddA(View view) {
        FragmentA f1 = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.group, f1, "A");
        transaction.commit();
    }

    public void AddB(View view) {
        FragmentB f2 = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.group, f2, "B");
        transaction.commit();
    }

    public void RemoveA(View view) {

    }

    public void RemoveB(View view) {

    }

    public void ReplaceAB(View view) {

    }

    public void ReplaceBA(View view) {

    }

    public void AttachA(View view) {

    }

    public void DetachA(View view) {

    }
}
