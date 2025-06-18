package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class southern_highest extends AppCompatActivity {
    Button l7;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_southern_highest);
        l7 = findViewById(R.id.l7);
        l7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(southern_highest.this, Map.class);
                intent.putExtra("latitude", 6.032124664735708);
                intent.putExtra("longitude", 80.21239952437926);
                intent.putExtra("title", "Le Grand Galle");
                startActivity(intent);
            }
        });
    }
}