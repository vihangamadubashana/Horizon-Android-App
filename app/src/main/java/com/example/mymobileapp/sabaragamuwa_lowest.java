package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sabaragamuwa_lowest extends AppCompatActivity {
    Button l12;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabaragamuwa_lowest);
        l12 = findViewById(R.id.l12);
        l12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sabaragamuwa_lowest.this, Map.class);
                intent.putExtra("latitude", 7.300605104667797);
                intent.putExtra("longitude", 80.38451993240108);
                intent.putExtra("title", "Hotel Elephant Park");
                startActivity(intent);
            }
        });
    }
}