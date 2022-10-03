package com.example.hsaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class HomePage extends AppCompatActivity {

    boolean isfan=false;

   private   SwitchCompat Switch,Switch1;
     private ImageView light,light1;
     private TextView zero;
     private SeekBar Sk;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Switch = findViewById(R.id.Switch);
        Switch1 =findViewById(R.id.Switch1);
        light = findViewById(R.id.light);
        light1=findViewById(R.id.light1);
        zero=findViewById(R.id.zero);
        Sk=findViewById(R.id.Sk);


        Sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int i =10;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                i=progress;
                zero.setText(""+i);
                int i = (int) Math.ceil(progress / 1000f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                zero.setText(""+i);

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton,boolean b) {
                if (compoundButton.isChecked()){
                    light.setImageResource(R.drawable.lightbulb1);
//                    gotoUrl("https://iotmachlab.000webhostapp.com/api/LED_1/update.php?id=1&status=on");
                }else {
                    light.setImageResource(R.drawable.bulb2);
//                    gotoUrl("https://iotmachlab.000webhostapp.com/api/LED_1/update.php?id=1&status=off");
                }
            }
        }); Switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton,boolean b) {
                if (compoundButton.isChecked()){
                    light1.setImageResource(R.drawable.lightbulb2);
//                    gotoUrl("https://iotmachlab.000webhostapp.com/api/LED_1/update.php?id=1&status=on");
                }else {
                    light1.setImageResource(R.drawable.bulb1);
//                    gotoUrl("https://iotmachlab.000webhostapp.com/api/LED_1/update.php?id=1&status=off");
                }
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri =Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));


    }
}