package com.example.homeworkapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutClassActivity extends AppCompatActivity {
    Button btnaboutclassback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_class);
        btnaboutclassback = (Button) findViewById(R.id.btnaboutclassback);
        btnaboutclassback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutClassActivity.this, AboutAppActivity.class);
                startActivity(intent);
            }
        });
    }
}