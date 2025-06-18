package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sabaragamuwa_highest extends AppCompatActivity {
    Button l10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabaragamuwa_highest);
        l10 = findViewById(R.id.l10);
        l10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sabaragamuwa_highest.this, Map.class);
                intent.putExtra("latitude", 7.017845834135578);
                intent.putExtra("longitude",  80.415731768513);
                intent.putExtra("title", "Moksha Kitulgala");
                startActivity(intent);
            }
        });
    }
}