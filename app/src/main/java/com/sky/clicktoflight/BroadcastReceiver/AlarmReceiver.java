package com.sky.clicktoflight.BroadcastReceiver;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.sky.clicktoflight.R;

public class AlarmReceiver extends BroadcastReceiver {
    private static final String TAG = AlarmReceiver.class.getName();

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG,"Receiver收到");
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent1 = new Intent();
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        NotificationChannel channel = new NotificationChannel("123", "123", NotificationManager.IMPORTANCE_HIGH);//生成channel
        //为channel添加属性
        channel.enableVibration(true);
        channel.enableLights(true);
        notificationManager.createNotificationChannel(channel);
        Notification.Builder builder = new Notification.Builder(context,"123")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("Reservation Time Out")
                .setContentTitle("Reservation Time Out")
                .setContentText("2 Hours Boarding Pass Reservation Is Time Out, Please Confirm! Otherwise Will Be Cancel")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);
        Notification notify1 = builder.build();
        notificationManager.notify(0,builder.build());
        Log.d(TAG, "应该有通知了吧");
    }
}
