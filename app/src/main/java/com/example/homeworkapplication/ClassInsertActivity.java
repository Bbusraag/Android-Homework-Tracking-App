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

public class ClassInsertActivity extends AppCompatActivity {
    EditText class_name,class_ide;
    Button insert,delete,view,update,back;
    ClassDb db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_insert);
        class_name=findViewById(R.id.ClassName);
        class_ide=findViewById(R.id.ClassIde);
        insert=findViewById(R.id.btnClassInsert);
        delete=findViewById(R.id.btnClassDelete);
        update=findViewById(R.id.btnclassupdate);
        view=findViewById(R.id.btnClassView);
        back=findViewById(R.id.btnclassback);
        db=new ClassDb(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ClassInsertActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=class_name.getText().toString();

                String IdeTXT=class_ide.getText().toString();

                Boolean checkclassinsertdata=db.classinsertdata(nameTXT,IdeTXT);
                if(checkclassinsertdata==true)
                    Toast.makeText(ClassInsertActivity.this,"New Entry Inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ClassInsertActivity.this,"New Entry not Inserted",Toast.LENGTH_SHORT).show();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=class_name.getText().toString();

                String IdeTXT=class_ide.getText().toString();

                Boolean checkupdatedata=db.classupdatedata(nameTXT,IdeTXT);
                if(checkupdatedata==true)
                    Toast.makeText(ClassInsertActivity.this,"New Entry Updated",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ClassInsertActivity.this,"New Entry not Updated",Toast.LENGTH_SHORT).show();
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=class_name.getText().toString();


                Boolean checkdeletedata=db.classdeletedata(nameTXT);
                if(checkdeletedata==true)
                    Toast.makeText(ClassInsertActivity.this," Entry deleted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ClassInsertActivity.this,"Entry not deleted",Toast.LENGTH_SHORT).show();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=db.classgetdata();
                if(res.getCount()==0){
                    Toast.makeText(ClassInsertActivity.this," Not Entry exist",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                    buffer.append( " Class Name:"+res.getString(0)+"\n");
                    buffer.append( "Class Ide:"+res.getString(1)+"\n");

                }
                AlertDialog.Builder builder=new AlertDialog.Builder(ClassInsertActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Class Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}