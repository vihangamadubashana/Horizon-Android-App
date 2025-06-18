package com.example.mymobileapp;

import static com.example.mymobileapp.R.id.nav_logOut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
public class dashboard extends AppCompatActivity{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9;

    protected void onCreate(Bundle savedIntenceState) {
        super.onCreate(savedIntenceState);
        setContentView(R.layout.activity_dashboard);
        // Initializing CardViews
        CardView c1 = findViewById(R.id.c1);
        CardView c2 = findViewById(R.id.c2);
        CardView c3 = findViewById(R.id.c3);
        CardView c4 = findViewById(R.id.c4);
        CardView c5 = findViewById(R.id.c5);
        CardView c6 = findViewById(R.id.c6);
        CardView c7 = findViewById(R.id.c7);
        CardView c8 = findViewById(R.id.c8);
        CardView c9 = findViewById(R.id.c9);

        setUpToolbar();
        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case  R.id.nav_home:

                        Intent intent = new Intent(dashboard.this, dashboard.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_location:
                        Intent intent1 = new Intent(dashboard.this,location_tracking.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_about:
                        Intent intent2 = new Intent(dashboard.this,aboutUs.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_notification:
                        Intent intent3 = new Intent(dashboard.this,notification.class);
                        startActivity(intent3);
                        break;
                    case nav_logOut:
                        // Create a new AlertDialog.Builder object
                        AlertDialog.Builder builder = new AlertDialog.Builder(dashboard.this);

                        // Inflate the custom dialog layout
                        View dialogView = LayoutInflater.from(dashboard.this).inflate(R.layout.dialog_layout, null);

                        // Set the view of the dialog to the inflated layout
                        builder.setView(dialogView);

                        // Find the views in the dialog layout
                        TextView discardTxt = dialogView.findViewById(R.id.txtDiscard);
                        Button logoutButton = dialogView.findViewById(R.id.btnDialogLogout);

                        // Create the dialog object
                        final AlertDialog dialog = builder.create();

                        // Set the click listener for the cancel button
                        discardTxt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Dismiss the dialog
                                dialog.dismiss();
                            }
                        });

                        // Set the click listener for the logout button
                        logoutButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Start the login activity
                                Intent intent = new Intent(dashboard.this, home.class);
                                startActivity(intent);

                                // Dismiss the dialog
                                dialog.dismiss();
                            }
                        });

                        // Show the dialog
                        dialog.show();
                        break;


//Paste your privacy policy link

//                    case  R.id.nav_Policy:{
//
//                        Intent browserIntent  = new Intent(Intent.ACTION_VIEW , Uri.parse(""));
//                        startActivity(browserIntent);
//
//                    }
                    //       break;
                    case  R.id.nav_share:{

                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        String shareBody =  "http://play.google.com/store/apps/detail?id=" + getPackageName();
                        String shareSub = "Try now";
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "Share using"));

                    }
                    break;
                }
                return false;
            }

        });


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard.this,selection.class));
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard.this,selection_southern.class));
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard.this,Sabaragamuwa_selection.class));
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard.this,Central_selection.class));
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard.this,Uva_selection.class));
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard.this,Nw_selection.class));
            }
        });
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard.this,Eastern_selection.class));
            }
        });
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard.this,Nc_selection.class));
            }
        });
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard.this,North_selection.class));
            }
        });

    }
    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }
}