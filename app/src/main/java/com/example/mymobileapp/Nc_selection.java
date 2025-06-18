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

public class Nc_selection extends AppCompatActivity{

    CardView Nc1,Nc2,Nc3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nc_selection);

        Nc1 = findViewById(R.id.Nc1);
        Nc2 = findViewById(R.id.Nc2);
        Nc3 = findViewById(R.id.Nc3);
        Nc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nc_selection.this,North_central_highest.class);
                startActivity(intent);
            }
        });

        Nc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nc_selection.this,North_central_middle.class);
                startActivity(intent);
            }
        });

        Nc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nc_selection.this,North_central_lowest.class);
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