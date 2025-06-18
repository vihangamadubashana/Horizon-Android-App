package com.example.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class notification extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final String CHANNEL_ID = "notification";
    private Button btnNotification;
    private List<Integer> notificationIds;
    private List<String> notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+ getPackageName() + "/" + R.raw.video);
        videoView.start();

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        btnNotification = findViewById(R.id.btnNotification);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        notificationIds = new ArrayList<>();
        notifications = new ArrayList<>();
        addNotifications();

        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(notification.this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(notification.this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, PERMISSION_REQUEST_CODE);
                } else {
                    showRandomNotification();
                }
            }
        });
    }

    private void addNotifications() {
        notifications.add("Hilton colombo  Hotel in Western Province  added to the highest categories. Now you can see the relevant details.");
        notifications.add("Mermaid hotel in Western Province  has been removed from the recommended list.");
        notifications.add("Le Grand Galle Hotel in Southern Province was added to the Highest category. Now you can see the relevant details.");
        notifications.add("This is the fourth type of notification.");
        notifications.add("Marino Beach Hotel in Western Province was added to the middle category. Now you can see the relevant details.");

        for (int i = 0; i < notifications.size(); i++) {
            notificationIds.add(i);
        }
    }

    @SuppressLint("MissingPermission")
    private void showRandomNotification() {
        if (notificationIds.isEmpty()) {
            resetNotificationIds(); // Reset the notification IDs if all notifications have been shown
        }

        int randomIndex = new Random().nextInt(notificationIds.size());
        int randomNotificationId = notificationIds.get(randomIndex);
        String notificationText = notifications.get(randomNotificationId);

        notificationIds.remove(randomIndex); // Remove the used notification ID

        NotificationCompat.Builder builder = new NotificationCompat.Builder(notification.this, CHANNEL_ID);
        builder.setContentTitle("MyMobileApp");
        builder.setContentText(notificationText);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText)); // Set the big text style
        builder.setSmallIcon(R.drawable.baseline_notifications_24);
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(notification.this);
        managerCompat.notify(randomNotificationId, builder.build());
    }

    private void resetNotificationIds() {
        notificationIds.clear();
        for (int i = 0; i < notifications.size(); i++) {
            notificationIds.add(i);
        }
    }

    private void clearAllNotifications() {
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(notification.this);
        managerCompat.cancelAll();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearAllNotifications();
    }
}