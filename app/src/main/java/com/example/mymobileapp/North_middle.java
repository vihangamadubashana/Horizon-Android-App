package com.example.mymobileapp;

import androidx.appcompat.
        app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class North_middle extends AppCompatActivity {
    Button l17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_middle);
        l17 = findViewById(R.id.l17);
        l17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(North_middle.this, Map.class);
                intent.putExtra("latitude", 9.664494441470193);
                intent.putExtra("longitude", 80.0205857944558);
                intent.putExtra("title", "North Gate Hotel");
                startActivity(intent);
            }
        });
    }
}