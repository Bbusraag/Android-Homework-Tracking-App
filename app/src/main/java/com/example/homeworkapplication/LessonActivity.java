package com.example.homeworkapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LessonActivity extends AppCompatActivity {
    Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        btnInsert = (Button) findViewById(R.id.btnbiolog);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LessonActivity.this, LessonInsertActivity.class);
                startActivity(intent);
            }
        });
    }
}