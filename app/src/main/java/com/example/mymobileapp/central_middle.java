package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class central_middle extends AppCompatActivity {
    Button l26;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_middle);
        l26 = findViewById(R.id.l26);
        l26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(central_middle.this, Map.class);
                intent.putExtra("latitude", 7.041066536843941);
                intent.putExtra("longitude", 80.75774034971063);
                intent.putExtra("title", "Mandaram Eco Resort");
                startActivity(intent);
            }
        });
    }
}