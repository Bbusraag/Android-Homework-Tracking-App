package com.example.homeworkapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button button2;
    Button btnlesson;
    Button btnstudent;
    Button btnApp;
    Button btnHomework;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnlesson = (Button) findViewById(R.id.btnLesson);
        btnstudent= (Button) findViewById(R.id.btnStudent);
        btnlesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,LessonActivity.class);
                startActivity(intent);
            }
        });
        btnstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,StudentListViewActivity.class);
                startActivity(intent);
            }
        });
        button2=(Button)findViewById(R.id.btnClass);
        button2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                openStudentActivity();
                }

        });
}
    public void openStudentActivity(){
        Intent intent=new Intent(this,ClassActivity.class);
        startActivity(intent);
    }

    }
