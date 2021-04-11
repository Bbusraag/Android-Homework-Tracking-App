package com.example.homeworkapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.homeworkapplication.model.DbHelper;
import com.example.homeworkapplication.model.User;

public class RegisterActivity extends AppCompatActivity {
    EditText etName, etEmail, etpassword, etRepassword;
    CheckBox cb8hours, cb24hours;
    RadioGroup rb;
    Button btnRegister, btnBack;
    Spinner spinnerSchool;
    TextView tvRegisterMessage;
    DbHelper dbHelper;
    String school = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbHelper = new DbHelper();
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etpassword = (EditText) findViewById(R.id.etpassword);
        etRepassword = (EditText) findViewById(R.id.etRepassword);
        cb8hours = (CheckBox) findViewById(R.id.cb8hours);
        cb24hours = (CheckBox) findViewById(R.id.cb24hours);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnBack = (Button) findViewById(R.id.btnBack);
      //  btnClear = (Button) findViewById(R.id.btnClear);
        tvRegisterMessage = findViewById(R.id.tvRegisterMessage);
        rb = (RadioGroup) findViewById(R.id.radiogroupGender);
        spinnerSchool = (Spinner) findViewById(R.id.spinnerSchool);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.SCHOOL, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSchool.setAdapter(adapter);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        spinnerSchool.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                school = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name = etName.getText().toString().trim();
                String password = etpassword.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String repassword = etRepassword.getText().toString().trim();
                String cbMessage = "";
                if (cb8hours.isChecked()) {
                    cbMessage = cb8hours.getText().toString();
                }
                if (cb24hours.isChecked()) {
                    if (cbMessage.equals(""))
                        cbMessage = cb24hours.getText().toString();
                    else
                        cbMessage = "," + cb24hours.getText().toString();
                }
                String gender = "";
                if (rb.getCheckedRadioButtonId() == R.id.rbMale) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                if (name.isEmpty()) {
                    tvRegisterMessage.setText("Please enter your name");
                    tvRegisterMessage.setTextColor(Color.RED);
                    etName.requestFocus();
                    return;
                }
                if (email.isEmpty()) {
                    tvRegisterMessage.setText("Please enter your email");
                    tvRegisterMessage.setTextColor(Color.RED);
                    etEmail.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    tvRegisterMessage.setText("Please enter your Password");
                    tvRegisterMessage.setTextColor(Color.RED);
                    etpassword.requestFocus();
                    return;
                }
                if (repassword.isEmpty()) {
                    tvRegisterMessage.setText("Please enter your Re-Password");
                    tvRegisterMessage.setTextColor(Color.RED);
                    etRepassword.requestFocus();
                    return;
                }
                if (!repassword.equals(password)) {
                    tvRegisterMessage.setText("Please enter your same Password and Re-Password");
                    tvRegisterMessage.setTextColor(Color.RED);
                    etRepassword.requestFocus();
                    return;
                }
                if (gender.equals("")) {
                    tvRegisterMessage.setText("Please select gender");
                    tvRegisterMessage.setTextColor(Color.RED);
                    return;
                }
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setPassword(password);
                user.setGender(gender);
                user.setSchool(school);
                if (dbHelper.AddUser(user)) {
                    tvRegisterMessage.setText("User Add Succesfull");
                    tvRegisterMessage.setTextColor(Color.GREEN);
                }
            }
        });
    }

}