package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class North_central_middle extends AppCompatActivity {
    Button l20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_central_middle);
        l20 = findViewById(R.id.l20);
        l20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(North_central_middle.this, Map.class);
                intent.putExtra("latitude", 8.324362652357731);
                intent.putExtra("longitude",  80.38283929625756);
                intent.putExtra("title", "Earl's Rajarata");
                startActivity(intent);
            }
        });
    }
}