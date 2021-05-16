package com.example.homeworkapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutAppActivity extends AppCompatActivity {
   Button btnhomework;
    Button btnlesson;
    Button btnclass;
    Button btnstudent;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        btnlesson = (Button) findViewById(R.id.btnAboutLesson);
        btnhomework = (Button) findViewById(R.id.btnabouthomework);
        btnclass = (Button) findViewById(R.id.btnAboutClass);
        btnstudent = (Button) findViewById(R.id.btnAboutStudent);
        back= (Button) findViewById(R.id.button19);
        btnlesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutAppActivity.this, AboutLessonActivity.class);
                startActivity(intent);
            }
        });

        btnhomework.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutAppActivity.this, AboutHomeworkActivity.class);
                startActivity(intent);
            }
        });
        btnclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutAppActivity.this, AboutClassActivity.class);
                startActivity(intent);
            }
        });
        btnstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutAppActivity.this, AboutStudentActivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutAppActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}