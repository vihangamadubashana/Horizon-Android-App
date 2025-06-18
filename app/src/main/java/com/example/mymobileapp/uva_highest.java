package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class uva_highest extends AppCompatActivity {
    Button l4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uva_highest);
        l4 = findViewById(R.id.l4);
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(uva_highest.this, Map.class);
                intent.putExtra("latitude", 6.757071124603963);
                intent.putExtra("longitude", 80.92721918200311);
                intent.putExtra("title", "Melheim Hotel");
                startActivity(intent);
            }
        });
    }
}