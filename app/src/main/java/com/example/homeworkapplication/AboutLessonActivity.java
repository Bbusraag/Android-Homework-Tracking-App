package com.example.homeworkapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutLessonActivity extends AppCompatActivity {
    Button btnabouthomeworkback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_lesson);
        btnabouthomeworkback = (Button) findViewById(R.id.btnaboutLessonback);
        btnabouthomeworkback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutLessonActivity.this, AboutAppActivity.class);
                startActivity(intent);
            }
        });
    }
}