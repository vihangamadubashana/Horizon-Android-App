package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Uva_middle extends AppCompatActivity {
    Button l5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uva_middle);
        l5 = findViewById(R.id.l5);
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Uva_middle.this, Map.class);
                intent.putExtra("latitude", 6.762066887833317);
                intent.putExtra("longitude", 80.9285605423277);
                intent.putExtra("title", "Blackwood Hotel");
                startActivity(intent);
            }
        });
    }
}