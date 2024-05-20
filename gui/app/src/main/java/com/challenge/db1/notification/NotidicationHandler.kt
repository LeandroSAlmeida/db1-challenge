package com.challenge.db1.notification

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.challenge.db1.R
import kotlin.random.Random

class NotificationHandler(private val context: Context) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    private val notificationChannelID = "notification_channel_id"

    // SIMPLE NOTIFICATION
    fun showSimpleNotification() {
        val notification = NotificationCompat.Builder(context, notificationChannelID)
            .setContentTitle("Simple Notification")
            .setContentText("Message or text with notification")
            .setSmallIcon(R.drawable.ic_notification_icon) // Certifique-se de usar um ícone adequado
            .setPriority(NotificationCompat.PRIORITY_HIGH) // Corrigido para NotificationCompat.PRIORITY_HIGH
            .setAutoCancel(true)
            .build()  // Finaliza a criação

        notificationManager.notify(Random.nextInt(), notification)
    }
}
