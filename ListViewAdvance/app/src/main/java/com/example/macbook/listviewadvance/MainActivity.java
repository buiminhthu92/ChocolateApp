package com.example.macbook.listviewadvance;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import com.example.macbook.listviewadvance.adapter.StudentAdapter;
import com.example.macbook.listviewadvance.model.Student;

import java.util.ArrayList;


public class MainActivity extends Activity {
    //khai bao
    private GridView lvStudent;
    private ArrayList<Student> arrayStudent;
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //khoi tao
        lvStudent = (GridView)findViewById(R.id.lvStudent);
        arrayStudent = new ArrayList<Student>();
        lvStudent.setNumColumns(2);
        lvStudent.getStretchMode();

        fakeData();

        adapter = new StudentAdapter(MainActivity.this, R.layout.layout_item_listview, arrayStudent);
        lvStudent.setAdapter(adapter);
    }

    //do chua co du lieu mang nen se tao gia du lieu
    public void fakeData(){
        for (int i = 0; i< 40; i++){
            Student student = new Student(
                    BitmapFactory.decodeResource(getResources(), R.drawable.calo_thuc_pham));
            arrayStudent.add(student);
        }
    }


}
