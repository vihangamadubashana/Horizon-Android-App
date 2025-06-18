package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class central_lowest extends AppCompatActivity {
    Button l27;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_lowest);
        l27 = findViewById(R.id.l27);
        l27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(central_lowest.this, Map.class);
                intent.putExtra("latitude", 7.276815136423386);
                intent.putExtra("longitude", 80.67634894125365);
                intent.putExtra("title", "Serendip Stone Bungalow & Hotel");
                startActivity(intent);
            }
        });
    }
}