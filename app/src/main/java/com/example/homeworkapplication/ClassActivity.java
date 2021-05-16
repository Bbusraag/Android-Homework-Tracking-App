package com.example.homeworkapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClassActivity extends AppCompatActivity {
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        button2=(Button)findViewById(R.id.btnClassEnter);
        button2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                openClassInsertActivity();
            }

        });
    }
    public void openClassInsertActivity(){
        Intent intent=new Intent(this, ClassInsertActivity.class);
        startActivity(intent);

    }
    }
