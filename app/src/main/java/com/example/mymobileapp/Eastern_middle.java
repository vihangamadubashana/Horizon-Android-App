package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Eastern_middle extends AppCompatActivity {
    Button l23;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eastern_middle);
        l23 = findViewById(R.id.l23);
        l23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Eastern_middle.this, Map.class);
                intent.putExtra("latitude", 8.618363593591845);
                intent.putExtra("longitude", 81.21543361414383);
                intent.putExtra("title", "Amaranthé Bay Resort");
                startActivity(intent);
            }
        });
    }
}