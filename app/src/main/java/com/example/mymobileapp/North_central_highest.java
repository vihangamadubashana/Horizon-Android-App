package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class North_central_highest extends AppCompatActivity {
    Button l19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_central_highest);
        l19 = findViewById(R.id.l19);
        l19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(North_central_highest.this, Map.class);
                intent.putExtra("latitude", 8.344064142896194);
                intent.putExtra("longitude", 80.39164497185342);
                intent.putExtra("title", "The Sanctuary Hotell");
                startActivity(intent);
            }
        });
    }
}