package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Uva_lowest extends AppCompatActivity {
    Button l6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uva_lowest);
        l6 = findViewById(R.id.l6);
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Uva_lowest.this, Map.class);
                intent.putExtra("latitude", 6.872004285556245);
                intent.putExtra("longitude", 81.05641665316756);
                intent.putExtra("title", "Ella Golden Rock Ella");
                startActivity(intent);
            }
        });
    }
}