package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class central_highest extends AppCompatActivity {
    Button l25;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_highest);
        l25 = findViewById(R.id.l25);
        l25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(central_highest.this, Map.class);
                intent.putExtra("latitude", 6.917400344863156);
                intent.putExtra("longitude", 80.58666445254822);
                intent.putExtra("title", "The Argyle - Luxury Boutique Hotel");
                startActivity(intent);
            }
        });
    }
}