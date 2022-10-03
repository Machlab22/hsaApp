package com.example.hsaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
  SwitchCompat Swtich;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        Swtich = findViewById(R.id.Switch);

        Swtich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton,boolean b) {
                if (compoundButton.isChecked()){
                    img.setImageResource(R.drawable.lightbulb1);
//                    gotoUrl("https://iotmachlab.000webhostapp.com/api/LED_1/update.php?id=1&status=on");
                }else {
                    img.setImageResource(R.drawable.bulb2);
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