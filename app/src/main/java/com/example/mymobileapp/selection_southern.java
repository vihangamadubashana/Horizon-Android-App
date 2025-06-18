package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.view.View;

public class selection_southern extends AppCompatActivity implements View.OnClickListener {

    CardView v1,v2,v3;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_southern);

        v1 = (CardView) findViewById(R.id.v1);
        v2 = (CardView) findViewById(R.id.v2);
        v3 = (CardView)findViewById(R.id.v3);

        v1.setOnClickListener(this);
        v2.setOnClickListener(this);
        v3.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.v1:
                i=new Intent(this,southern_highest.class);
                startActivity(i);
                break;
            case R.id.v2:
                i=new Intent(this,southern_middle.class);
                startActivity(i);
                break;
            case R.id.v3:
                i=new Intent(this,southern_lowest.class);
                startActivity(i);
                break;
        }
    }
}