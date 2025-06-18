package com.example.mymobileapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.common.api.ApiException;

public class sign_in extends AppCompatActivity {

    EditText mail;// EditText field for email
    EditText pass;// EditText field for password
    Button loginButton;// Button for login
    TextView forget;// TextView for the "Forget Password" action


    DBHelper DB;// Instance of the DBHelper class for database operations

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Initialize the EditText fields, the button, and the DBHelper instance
        mail = findViewById(R.id.loginEmail);
        pass = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.btn_log2);

        DB = new DBHelper(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mail.getText().toString();// Get the email entered by the user
                String password = pass.getText().toString(); // Get the password entered by the user

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    // Check if any of the fields is empty
                    Toast.makeText(sign_in.this, "All fields Required", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserpass = DB.checkEmailPassword(email,password);// Check if the email and password combination exists in the database
                    if (checkuserpass == true) {
                        // If the email and password combination exists
                        Toast.makeText(sign_in.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), dashboard.class);// Create an intent to navigate to the dashboard activity
                        startActivity(intent);// Start the dashboard activity
                    } else {
                        // If the email and password combination does not exist
                        Toast.makeText(sign_in.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    public void forget(View view){
        // Function to handle the "Forget Password" action
        Intent intent=new Intent(getApplicationContext(),Forget.class);
        startActivity(intent);
    }

}