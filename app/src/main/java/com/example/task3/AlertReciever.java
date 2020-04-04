package com.example.task3;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class AlertReciever extends BroadcastReceiver {

    private NotificationManagerCompat notificationManager;


    @Override
    public void onReceive(Context context, Intent intent) {

        notificationManager = NotificationManagerCompat.from(context);

        Notification notification12 = new Notification.Builder(context)
                .setContentTitle("TEST")
                .setContentText("provekra")
                .setPriority(Notification.PRIORITY_HIGH)
                .setSmallIcon(R.drawable.ic_add_alert_black_24dp)
                .setSound(Uri.parse("android.resource://"
                        + context.getPackageName() + "/"
                        + R.raw.alarm))
                .build();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification notification = new NotificationCompat.Builder(context, NotificationHelper.getChannel1Id())
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentText("AAAA")
                    .setContentTitle("Alarm")
                    .build();

            notificationManager.notify(1, notification);

        } else {

           notificationManager.notify(2, notification12);
        }
    }
}


