package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class southern_middle extends AppCompatActivity {
    Button l8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_southern_middle);
        l8 = findViewById(R.id.l8);
        l8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(southern_middle.this, Map.class);
                intent.putExtra("latitude", 6.0355126361279166);
                intent.putExtra("longitude",  80.2158048108354);
                intent.putExtra("title", "Hottel Brixia");
                startActivity(intent);
            }
        });
    }
}