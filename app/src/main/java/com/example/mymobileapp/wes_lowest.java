package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class wes_lowest extends AppCompatActivity {
    Button l1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wes_lowest);
        l1 = findViewById(R.id.l1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wes_lowest.this, Map.class);
                intent.putExtra("latitude", 6.900278217891883);
                intent.putExtra("longitude",  79.85362140996469);
                intent.putExtra("title", "Mandarina Hotel");
                startActivity(intent);
            }
        });
    }
}