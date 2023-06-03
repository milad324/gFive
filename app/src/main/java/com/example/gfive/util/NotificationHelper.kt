package com.example.gfive.util

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.gfive.R
import com.example.gfive.util.Constants.Companion.CHANEL_ID

class NotificationHelper {
    fun createNotification(context: Context, intent: Intent): Notification {
        return NotificationCompat.Builder(context, CHANEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("G Five reminder")
            .setContentText("Don't Forget to Answer Your Card's")
            .build()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChanel(context: Context,name: String, desc: String) {
        val channel = NotificationChannel(CHANEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT)
        channel.description = desc
        val notificationManager=context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}
