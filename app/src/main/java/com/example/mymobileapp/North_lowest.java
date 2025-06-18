package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class North_lowest extends AppCompatActivity {
    Button l18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_lowest);
        l18 = findViewById(R.id.l18);
        l18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(North_lowest.this, Map.class);
                intent.putExtra("latitude", 9.57772507572448);
                intent.putExtra("longitude", 80.41178238465501);
                intent.putExtra("title", "Reecha Mullai Hotel");
                startActivity(intent);
            }
        });
    }
}