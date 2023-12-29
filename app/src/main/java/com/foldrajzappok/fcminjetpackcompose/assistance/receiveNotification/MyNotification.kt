package com.foldrajzappok.fcminjetpackcompose.assistance.receiveNotification

import android.app.ActivityManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.net.toUri
import com.foldrajzappok.fcminjetpackcompose.MainActivity
import com.foldrajzappok.fcminjetpackcompose.R

class MyNotification(var context: Context, var title: String, var msg: String) {
    val channelId = "FCM100"
    val channelName = "FCMessage"
    val notificationManager =
        context.applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    lateinit var notificatonChannel: NotificationChannel
    lateinit var notificationBuilder: NotificationCompat.Builder

    fun isAppInforegrounded() : Boolean {
        val appProcessInfo =  ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(appProcessInfo);
        return (appProcessInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND ||
                appProcessInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE)
    }

    fun fireNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificatonChannel =
                NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificatonChannel)
        }

        //here you can set where to navigate the user when taps on the notification
        val intent = Intent(
            Intent.ACTION_VIEW,
            "FCMinJCApp://StartScreen".toUri(),
            context,
            MainActivity::class.java
        )

        val pendingIntent =
            PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        //the notificationBulider has more methods, here are some basic methods
        if(!isAppInforegrounded()) {
            notificationBuilder = NotificationCompat.Builder(context, channelId)
            notificationBuilder.setSmallIcon(R.mipmap.ic_launcher_round)
            notificationBuilder.addAction(
                R.mipmap.ic_launcher_round,
                "Open the app",
                pendingIntent
            )
            notificationBuilder.setContentTitle(title)
            notificationBuilder.setContentText(msg)
            notificationBuilder.setContentIntent(pendingIntent)
            notificationBuilder.setAutoCancel(true)
            notificationManager.notify(100, notificationBuilder.build())
        }
    }
}