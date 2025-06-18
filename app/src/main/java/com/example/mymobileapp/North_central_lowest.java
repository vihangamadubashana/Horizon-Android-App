package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class North_central_lowest extends AppCompatActivity {
    Button l21;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_central_lowest);
        l21 = findViewById(R.id.l21);
        l21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(North_central_lowest.this, Map.class);
                intent.putExtra("latitude", 8.30702202109654);
                intent.putExtra("longitude",   80.44062594367074);
                intent.putExtra("title", "Earl's Rajarata");
                startActivity(intent);
            }
        });
    }
}