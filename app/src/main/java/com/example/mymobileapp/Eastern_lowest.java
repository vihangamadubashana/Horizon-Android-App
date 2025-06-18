package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Eastern_lowest extends AppCompatActivity {
    Button l24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eastern_lowest);
        l24 = findViewById(R.id.l24);
        l24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Eastern_lowest.this, Map.class);
                intent.putExtra("latitude", 7.728734033949289);
                intent.putExtra("longitude", 81.7049022040259);
                intent.putExtra("title", "Hotel East Lagoon");
                startActivity(intent);
            }
        });
    }
}