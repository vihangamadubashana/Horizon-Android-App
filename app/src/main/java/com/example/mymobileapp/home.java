package com.example.mymobileapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity
        implements SensorEventListener {
    Button btn_sign,btnsign_up;

    //sensor related variables
    SensorManager sensorManager;
    Sensor sensor;
    public boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_sign = findViewById( R.id.btn_sign);
        btnsign_up =findViewById( R.id.btnsign_up);
        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,sign_in.class));
            }
        });
        btnsign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,sign_up.class));
            }
        });

        //sensor related variables
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        PackageManager packageManager = getPackageManager();
        boolean hasLightSensor = packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_LIGHT);
        if(hasLightSensor) {
            // Light sensor is available on the device
            Toast.makeText(this, "Light sensor available", Toast.LENGTH_SHORT).show();
        } else {
            // Light sensor is not available on the device
            Toast.makeText(this, "Light sensor not available", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            float lightvalue = event.values[0];

            if (event.values[0] > 100 && !isRunning) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setTitle("Alert");
                alertDialog.setMessage(lightvalue + "\n" + "Increase your Display Brightness !");
                isRunning = true;
                //When click "Yes" it will execute this
                alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
            } else if (event.values[0] <= 100) {
                isRunning = false;
            }
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Method required to implement SensorEventListener
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}