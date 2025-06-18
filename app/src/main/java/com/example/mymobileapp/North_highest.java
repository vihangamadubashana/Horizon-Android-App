package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class North_highest extends AppCompatActivity {
    Button l16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_highest);
        l16 = findViewById(R.id.l16);
        l16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(North_highest.this, Map.class);
                intent.putExtra("latitude", 9.661405368840484);
                intent.putExtra("longitude", 80.0168843472466);
                intent.putExtra("title", "Jetwing Mahesa Bhawan");
                startActivity(intent);
            }
        });
    }
}