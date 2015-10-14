package com.gabbyberas.picassotest;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Android on 10/10/2015.
 */
public class DisplayList extends Activity {

    private ListView studentLv;
    private ArrayList<Student> arrayStudent;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);

        studentLv = (ListView)findViewById(R.id.listView);
        arrayStudent = new ArrayList<Student>();

        fakeData();

        studentAdapter = new StudentAdapter(DisplayList.this, R.layout.listview_element, arrayStudent);
        studentLv.setAdapter(studentAdapter);
    }

    public void fakeData(){
        for (int i = 0; i< 40; i++){
            Student student = new Student(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher),
                    "Nguyen Van" + i);
            arrayStudent.add(student);
        }
    }
}
