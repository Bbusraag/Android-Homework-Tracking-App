package com.example.homeworkapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentActivity extends AppCompatActivity {
    Button btnstudentInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        btnstudentInsert= (Button) findViewById(R.id.btnAdd);
        btnstudentInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(StudentActivity.this,StudentInsertActivity.class);
                startActivity(intent);
            }
        });

    }
}