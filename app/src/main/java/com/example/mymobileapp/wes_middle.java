package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class wes_middle extends AppCompatActivity {
    Button l2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wes_middle);
        l2 = findViewById(R.id.l2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wes_middle.this, Map.class);
                intent.putExtra("latitude", 6.90030026765638);
                intent.putExtra("longitude",   79.85227075133206);
                intent.putExtra("title", "Marino Beach");
                startActivity(intent);
            }
        });
    }
}