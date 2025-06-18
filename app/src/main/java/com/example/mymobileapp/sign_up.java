package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_up extends AppCompatActivity {

    EditText f_name,l_name,signupEmail,signupPassword,signupConfirm;// EditText fields for first name, last name, email, password, and confirmation
    Button btn_login;// Button for the login action
    DBHelper DB;// Instance of the DBHelper class for database operations

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize the EditText fields and the button
        f_name=findViewById(R.id.province);
        l_name=findViewById(R.id.hotel);
        signupEmail=findViewById(R.id.prefered);
        signupPassword=findViewById(R.id.details);
        signupConfirm=findViewById(R.id.signupConfirm);
        btn_login=findViewById(R.id.btn_login);
        DB=new DBHelper(this);// Create an instance of the DBHelper class


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = f_name.getText().toString(); // Get the first name entered by the user
                String last = l_name.getText().toString();// Get the last name entered by the user
                String email = signupEmail.getText().toString();// Get the email entered by the user
                String password = signupPassword.getText().toString();// Get the password entered by the user
                String confirm=signupConfirm.getText().toString();// Get the confirmation entered by the user


                if(TextUtils.isEmpty(first) || TextUtils.isEmpty(last) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirm)  )
                    // Check if any of the fields is empt
                    Toast.makeText(sign_up.this,"All field Required", Toast.LENGTH_SHORT).show();

                    else{
                    if(password.equals(confirm)){
                        // Check if the password and confirmation match
                        Boolean checkuser = DB.checkEmail (email);// Check if the email already exists in the database
                        if(checkuser==false){
                            // If the email does not exist
                            Boolean insert = DB.insertData(first,last,email,password,confirm);
                            if(insert==true){
                                // If the insertion is successful
                                Toast.makeText(sign_up.this,"Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(),sign_in.class);
                                startActivity(i);// Start the sign-in activity
                            }else{
                                // If the insertion fails
                                Toast.makeText(sign_up.this,"Registered Failed",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            // If the email already exists
                            Toast.makeText(sign_up.this,"User already Exists", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        // If the password and confirmation do not match
                        Toast.makeText(sign_up.this,"Passwords are not matching",Toast.LENGTH_SHORT).show();
                    }


                }
            }
    });

    }
}