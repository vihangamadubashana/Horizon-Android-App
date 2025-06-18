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

public class Uva_selection extends AppCompatActivity{

    CardView u1,u2,u3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uva_selection);

        u1 = findViewById(R.id.u1);
        u2 = findViewById(R.id.u2);
        u3 = findViewById(R.id.u3);
        u1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Uva_selection.this,uva_highest.class);
                startActivity(intent);
            }
        });

        u2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Uva_selection.this,Uva_middle.class);
                startActivity(intent);
            }
        });

        u3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Uva_selection.this,Uva_lowest.class);
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