package com.example.hsaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class StartingPage extends AppCompatActivity {
    LottieAnimationView lottie,lottie1;
    TextView text,text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page);


        text=findViewById(R.id.text);
        text1=findViewById(R.id.text1);

        lottie1=findViewById(R.id.SubmitBtn);
        lottie =findViewById(R.id.laView);


        lottie1.setAnimation(R.raw.getstart);
        lottie1.playAnimation();
        lottie1.loop(true);

        lottie.setAnimation(R.raw.robites);
        lottie.playAnimation();
        lottie.loop(true);


        lottie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartingPage.this,Login.class));
                finish();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                 startActivity(intent);
                 finish();
            }
        },800000000);

    }
}