package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sabaragamuwa_middle extends AppCompatActivity {
    Button l11;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabaragamuwa_middle);
        l11 = findViewById(R.id.l11);
        l11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sabaragamuwa_middle.this, Map.class);
                intent.putExtra("latitude", 6.320146940836527);
                intent.putExtra("longitude", 80.85611429734537);
                intent.putExtra("title", "Centauria Lake Resort");
                startActivity(intent);
            }
        });
    }
}