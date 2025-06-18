package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class North_wes_highest extends AppCompatActivity {
    Button l13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_wes_highest);
        l13 = findViewById(R.id.l13);
        l13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(North_wes_highest.this, Map.class);
                intent.putExtra("latitude", 7.64121972805616);
                intent.putExtra("longitude", 79.80154612618912);
                intent.putExtra("title", "Anantaya Resort");
                startActivity(intent);
            }
        });
    }
}