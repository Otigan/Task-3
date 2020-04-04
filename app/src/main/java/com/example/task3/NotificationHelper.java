package com.example.task3;


import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationManagerCompat;

public class NotificationHelper extends Application {
    public static final String CHANNEL_1_ID = "CHANNEL 1";

    public static final String CHANNEL_2_ID = "CHANNEL 2";


    public static String getChannel2Id() { return  CHANNEL_2_ID; }

    public static String getChannel1Id() {
        return CHANNEL_1_ID;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Alarm",
                    NotificationManager.IMPORTANCE_HIGH
            );


            channel.enableVibration(true);
            channel.getSound();

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);


        }
    }
}
