package com.example.homeworkapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentInsertActivity extends AppCompatActivity {
    EditText name,surname,department;
    Button insert,delete,view,update,back;
    Dbhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_insert);
        name=findViewById(R.id.studentname);
        surname=findViewById(R.id.studentsurname);
        department=findViewById(R.id.studentdepart);
        insert=findViewById(R.id.btnInsert);
        delete=findViewById(R.id.btnDelete);
        update=findViewById(R.id.btnUpdate);
        view=findViewById(R.id.btnView);
        back=findViewById(R.id.btnStudentBack);
        db=new Dbhelper(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(StudentInsertActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();
                String surnameTXT=surname.getText().toString();
                String departmentTXT=department.getText().toString();

                Boolean checkinsertdata=db.insertdata(nameTXT,surnameTXT,departmentTXT);
                if(checkinsertdata==true)
                    Toast.makeText(StudentInsertActivity.this,"New Entry Inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(StudentInsertActivity.this,"New Entry not Inserted",Toast.LENGTH_SHORT).show();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();
                String surnameTXT=surname.getText().toString();
                String departmentTXT=department.getText().toString();

                Boolean checkupdatedata=db.updatedata(nameTXT,surnameTXT,departmentTXT);
                if(checkupdatedata==true)
                    Toast.makeText(StudentInsertActivity.this,"New Entry Updated",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(StudentInsertActivity.this,"New Entry not Updated",Toast.LENGTH_SHORT).show();
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();


                Boolean checkdeletedata=db.deletedata(nameTXT);
                if(checkdeletedata==true)
                    Toast.makeText(StudentInsertActivity.this," Entry deleted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(StudentInsertActivity.this,"Entry not deleted",Toast.LENGTH_SHORT).show();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=db.getdata();
                if(res.getCount()==0){
                    Toast.makeText(StudentInsertActivity.this," Not Entry exist",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                    buffer.append( "Name:"+res.getString(0)+"\n");
                    buffer.append( "Surname:"+res.getString(1)+"\n");
                    buffer.append( "Department :"+res.getString(2)+"\n\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(StudentInsertActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Student Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}