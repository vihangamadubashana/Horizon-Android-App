package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Selection;
import android.view.OrientationEventListener;
import android.view.View;

public class Sabaragamuwa_selection extends AppCompatActivity{

    CardView s1,s2,s3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabaragamuwa_selection);

        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        s3 = findViewById(R.id.s3);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sabaragamuwa_selection.this,sabaragamuwa_highest.class);
                startActivity(intent);
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sabaragamuwa_selection.this,sabaragamuwa_middle.class);
                startActivity(intent);
            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sabaragamuwa_selection.this,sabaragamuwa_lowest.class);
                startActivity(intent);
            }
        });


        OrientationEventListener orientationEventListener = new OrientationEventListener(this) {
            @Override


            public void onOrientationChanged(int orientation) {

                int epsil = 10;
                int leftscape = 90;
                int rightscape = 270;

                if(epsilCheck(orientation,leftscape,epsil) || epsilCheck(orientation,rightscape,epsil)){
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                }
            }

            private boolean epsilCheck(int orientation, int lscapeMode, int epsil){
                return orientation > lscapeMode - epsil && orientation < lscapeMode + epsil;
            }
        };

        orientationEventListener.enable();


    }
}