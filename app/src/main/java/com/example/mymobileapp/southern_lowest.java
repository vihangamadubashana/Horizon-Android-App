package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class southern_lowest extends AppCompatActivity {
    Button l9;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_southern_lowest);
        l9 = findViewById(R.id.l9);
        l9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(southern_lowest.this, Map.class);
                intent.putExtra("latitude", 6.044863025207587);
                intent.putExtra("longitude", 80.21605438385244);
                intent.putExtra("title", "Elliot Nature");
                startActivity(intent);
            }
        });
    }
}