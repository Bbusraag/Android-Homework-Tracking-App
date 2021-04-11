package com.example.homeworkapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homeworkapplication.model.DbHelper;

public class MainActivity extends AppCompatActivity{
    EditText etUserName;
    EditText etPassword;
    TextView textmessage;
    Button btnsign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsign=(Button)findViewById(R.id.btnsign);
        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    public void Login(View view){
         etUserName= (EditText) findViewById(R.id.etUserName);
         etPassword= (EditText) findViewById(R.id.etPassword);
         textmessage=(TextView) findViewById(R.id.textmessage);
         textmessage.setText("");
         textmessage.setTextColor(Color.RED);

        String username=etUserName.getText().toString().trim();
        String password=etPassword.getText().toString().trim();

         if(username.equals("")){
           textmessage.setText("Please enter user name");
           etUserName.requestFocus();
           return;
    }
        if(password.equals("")){
            textmessage.setText("Please enter password");
            etPassword.requestFocus();
            return;
        }
       if(username.equals("admin")&& password.equals("12345")) {
            //  textmessage.setText("Welcome," + username);
       // if(DbHelper.Login(username,password)){
            Intent intent = new Intent(this,HomeActivity.class);
            startActivity((intent));
        }
        else{
            textmessage.setText("Invalid username or password.");
        }
}
}