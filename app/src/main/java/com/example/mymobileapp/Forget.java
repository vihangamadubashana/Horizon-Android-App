package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Forget extends AppCompatActivity {

    EditText F_email,F_password,F_confirm;// EditText fields for email, password, and confirmation
    Button btn_login2;// Button for the login action
    DBHelper DB;// Instance of the DBHelper class for database operations

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        // Initialize the EditText fields and the button
        F_email=findViewById(R.id.F_email);
        F_password=findViewById(R.id.F_password);
        F_confirm=findViewById(R.id.F_confirm);
        btn_login2=(Button) findViewById(R.id.btn_login2);

        DB = new DBHelper(this);// Create an instance of the DBHelper class

        // Set a click listener for the login button
        btn_login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,pass,confirm;// Variables to store the values entered in the EditText fields
                try {
                    email = F_email.getText().toString();// Get the email entered by the user
                    pass = F_password.getText().toString();// Get the password entered by the user
                    confirm = F_confirm.getText().toString();// Get the confirmation entered by the user

                    if(email.equals("")|| pass.equals("")||confirm.equals("")){
                        // Check if any of the fields is empty
                        Toast.makeText(Forget.this, "can't empty", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (pass.equals(confirm)){
                            // Check if the password and confirmation match

                            // Call the updatepass method of DBHelper class to update the password
                            int updatepass=DB.updatepass(email,pass,confirm);
                            if(updatepass==1){
                                // If the update operation is successful
                                F_email.setText("");// Clear the email field
                                F_confirm.setText("");// Clear the confirmation field
                                Toast.makeText(Forget.this, "Successful Update", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(Forget.this,sign_in.class);
                                startActivity(intent);// Start the sign-in activity
                                finish();// Finish the current activity
                            }
                            else {
                                // If the update operation fails
                                Toast.makeText(Forget.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            // If the password and confirmation do not match
                            Toast.makeText(Forget.this, "Password mismatched", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                catch (Exception e){
                    // Exception occurred during the password update process
                    Toast.makeText(Forget.this, "Out of bound"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}