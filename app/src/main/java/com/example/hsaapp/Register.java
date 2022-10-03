package com.example.hsaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private EditText Username,Email,Mobile,Password,CPassword;
    private Button RegisterNowBtn;
    private TextView LoginNowBtn;
    boolean PasswordVisible,CPasswordVisible;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText Username = findViewById(R.id.Username);
        final EditText Email = findViewById(R.id.Email);
        final EditText Mobile = findViewById(R.id.Mobile);
        final EditText Password = findViewById(R.id.Password);
        final EditText CPassword = findViewById(R.id.CPassword);

        final Button RegisterNOwBtn = findViewById(R.id.RegisterNowBtn);
        final TextView LoginNowBtn = findViewById(R.id.LoginNowBtn);

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


        CPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if (event.getAction()==MotionEvent.ACTION_UP){
                    if (event.getRawX()>=CPassword.getRight()-CPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = CPassword.getSelectionEnd();
                        if (CPasswordVisible){
                            CPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            CPassword.setTransformationMethod(CPassword.getTransformationMethod());

                            CPasswordVisible=false;
                        }else{
                            CPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            CPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                            CPasswordVisible=true;
                        }
                        CPassword.setSelection(selection);
                        return true;
                    }

                }
                return false;
            }
        });


        RegisterNOwBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String UsernameTxt = Username.getText().toString();
                final String EmailTxt = Email.getText().toString();
                final String MobileTxt = Mobile.getText().toString();
                final String PasswordTxt = Password.getText().toString();
                final String CPasswordTxt = CPassword.getText().toString();

                if (UsernameTxt.isEmpty() || EmailTxt.isEmpty() || MobileTxt.isEmpty() || PasswordTxt.isEmpty()) {

                    Toast.makeText(Register.this, "Please fill the all Details", Toast.LENGTH_SHORT).show();

                } else if (!PasswordTxt.equals(CPasswordTxt)) {
                    Toast.makeText(Register.this, "Password are not match", Toast.LENGTH_SHORT).show();
                }
                LoginNowBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
            }
            });
    }
}