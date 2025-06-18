package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class North_wes_middle extends AppCompatActivity {
    Button l14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_wes_middle);
        l14 = findViewById(R.id.l14);
        l14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(North_wes_middle.this, Map.class);
                intent.putExtra("latitude", 7.293785773725747);
                intent.putExtra("longitude", 79.8395504752612);
                intent.putExtra("title", "Club Hotel Dolphin");
                startActivity(intent);
            }
        });
    }
}