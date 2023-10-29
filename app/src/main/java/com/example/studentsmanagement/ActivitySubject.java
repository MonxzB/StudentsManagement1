package com.example.studentsmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.studentsmanagement.adapter.adaptersubject;
import com.example.studentsmanagement.database.database;
import com.example.studentsmanagement.model.Subject;

import java.util.ArrayList;

public class ActivitySubject extends AppCompatActivity {

    Toolbar toolbar;
    ListView listViewsubject;
    ArrayList<Subject> ArrayListSubject;
    com.example.studentsmanagement.database.database database;
    com.example.studentsmanagement.adapter.adaptersubject adaptersubject;
    int count= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        toolbar= findViewById(R.id.toolbarSubject);
        listViewsubject= findViewById(R.id.listviewSubject);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database= new database(this);

        ArrayListSubject = new ArrayList<>();

        Cursor cursor= database.getDataSubject();
        while (cursor.moveToNext()){

            int id= cursor.getInt(0);
            String title= cursor.getString(1);
            int credit= cursor.getInt(2);
            String time= cursor.getString(3);
            String place= cursor.getString(4);

            ArrayListSubject.add(new Subject(id, title, credit, time, place));
        }

        adaptersubject= new adaptersubject(ActivitySubject.this, ArrayListSubject);
        listViewsubject.setAdapter(adaptersubject);
        cursor.moveToFirst();
        cursor.close();

    }

        // THÊM MỘT MENU LÀ ADD VÀO TOOLBAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menuadd, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int addm= R.id.menuAdd;
        switch (addm){
                // NẾU CLICK VÀO ADD THFI CHUYỂN QUA MÀN HÌNH ADD SUBJECT
            case 1:
                Intent intent1= new Intent(ActivitySubject.this, ActivityAddSubject.class);
                startActivity(intent1);
                break;
                // NẾU CLICK VÀO NÚT CÒN LẠI LÀ NÚT BACK THÌ QUAY LẠI MAIN
            default:
                Intent intent= new Intent(ActivitySubject.this, MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

        // NẾU CLICK BACK Ở ĐIỆN THOẠI SẼ TRỞ VỀ MAIN ACTIVITY
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        count++;
        if (count >= 1) {
            Intent intent = new Intent(ActivitySubject.this, MainActivity.class);
            startActivity(intent);
            finish();

        }

    }
    // RUN
}