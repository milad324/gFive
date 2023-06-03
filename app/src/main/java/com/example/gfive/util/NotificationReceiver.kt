package com.example.gfive.util

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.gfive.util.Constants.Companion.NOTIFICATION_ID


class NotificationReceiver : BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context, intent: Intent) {

        val notificationHelper = NotificationHelper()
        notificationHelper.createNotificationChanel(context, "name", "dec")
        val notification = notificationHelper.createNotification(context, intent)
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(NOTIFICATION_ID, notification)

    }
}
