package com.example.homeworkapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.homeworkapplication.model.StudentListViewAdapter;
import com.example.homeworkapplication.model.student;

import java.util.ArrayList;
import java.util.List;

public class StudentListViewActivity extends AppCompatActivity {
    List<student> studentList;
    ListView lvStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list_view);

        lvStudent = findViewById(R.id.lvStudent);
        studentList = new ArrayList<>();
      //  btnAdd = (Button) findViewById(R.id.btnAdd);
        studentList.add(new student("Ahmet", "Göktaş", "Software", R.drawable.man5));
        studentList.add(new student("Hasan", "Yılmaz", "Physics", R.drawable.man2));
        studentList.add(new student("Hüseyin", "Yıldırım", "Math", R.drawable.man3));
        studentList.add(new student("Büşra", "Öztürk", "Social", R.drawable.man4));

        StudentListViewAdapter adapter = new StudentListViewAdapter(this, R.layout.activity_student, studentList);
        lvStudent.setAdapter(adapter);


    }
}









