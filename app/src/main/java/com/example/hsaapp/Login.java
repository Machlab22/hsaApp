package com.example.hsaapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hsaapp.R;

public class Login extends AppCompatActivity {
    EditText Email,Password;
    Button SubmitBtn;
    TextView RegisterBtn;

    boolean PasswordVisible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText Email = findViewById(R.id.Email);
        final EditText Password = findViewById(R.id.Password);
        final Button SubmitBtn = findViewById(R.id.SubmitBtn);
        final TextView RegisterBtn = findViewById(R.id.RegisterBtn);

        Password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if (event.getAction()==MotionEvent.ACTION_UP){
                    if (event.getRawX()>=Password.getRight()-Password.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = Password.getSelectionEnd();
                        if (PasswordVisible){
                            Password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            Password.setTransformationMethod(Password.getTransformationMethod());

                            PasswordVisible=false;
                        }else{
                            Password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                            PasswordVisible=true;
                        }
                        Password.setSelection(selection);
                        return true;
                    }

                }
                return false;
            }
        });

        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String EmailTxt = Email.getText().toString();
                final String PasswordTxt = Password.getText().toString();
                if (EmailTxt.isEmpty() || PasswordTxt.isEmpty()){

                    Toast.makeText(Login.this, "Please enter your Email or Password", Toast.LENGTH_SHORT).show();
                }
                SubmitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Login.this,HomePage.class));
                        finish();
                    }
                });
            }
        });
        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }
}