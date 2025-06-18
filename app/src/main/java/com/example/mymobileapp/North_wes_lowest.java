package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class North_wes_lowest extends AppCompatActivity {
    Button l15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_wes_lowest);
        l15 = findViewById(R.id.l15);
        l15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(North_wes_lowest.this, Map.class);
                intent.putExtra("latitude", 7.394620373878678);
                intent.putExtra("longitude", 79.82062396851522);
                intent.putExtra("title", "Blue and Green Resort");
                startActivity(intent);
            }
        });
    }
}