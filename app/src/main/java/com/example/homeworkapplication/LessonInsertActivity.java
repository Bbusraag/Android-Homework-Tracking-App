package com.example.homeworkapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LessonInsertActivity extends AppCompatActivity {
    EditText lesson_name,lesson_department;
    Button insert,delete,view,update;
    LessonDb db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_insert);
        lesson_name=findViewById(R.id.LessonName);
        lesson_department=findViewById(R.id.LessonDepartment);
        insert=findViewById(R.id.btnbiolog);
        delete=findViewById(R.id.btnlessondelete);
        update=findViewById(R.id.btnlessonupdate);
        view=findViewById(R.id.btnlessonview);
        db=new LessonDb(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=lesson_name.getText().toString();

                String departmentTXT=lesson_department.getText().toString();

                Boolean checklessoninsertdata=db.lessoninsertdata(nameTXT,departmentTXT);
                if(checklessoninsertdata==true)
                    Toast.makeText(LessonInsertActivity.this,"New Entry Inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(LessonInsertActivity.this,"New Entry not Inserted",Toast.LENGTH_SHORT).show();
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=lesson_name.getText().toString();


                Boolean checklessondeletedata=db.lessondeletedata(nameTXT);
                if(checklessondeletedata==true)
                    Toast.makeText(LessonInsertActivity.this," Entry deleted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(LessonInsertActivity.this,"Entry not deleted",Toast.LENGTH_SHORT).show();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=db.lessongetdata();
                if(res.getCount()==0){
                    Toast.makeText(LessonInsertActivity.this," Not Entry exist",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                    buffer.append( "Name:"+res.getString(0)+"\n");
                    buffer.append( "Department:"+res.getString(1)+"\n");

                }
                AlertDialog.Builder builder=new AlertDialog.Builder(LessonInsertActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Lesson Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}