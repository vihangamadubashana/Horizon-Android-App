package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Eastern_highest extends AppCompatActivity {
    Button l22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eastern_highest);
        l22 = findViewById(R.id.l22);
        l22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Eastern_highest.this, Map.class);
                intent.putExtra("latitude", 7.872334017690396);
                intent.putExtra("longitude", 81.5669125484013);
                intent.putExtra("title", "Karpaha Sands");
                startActivity(intent);
            }
        });
    }
}