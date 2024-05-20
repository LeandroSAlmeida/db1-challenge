package com.challenge.db1.notification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi

class NotificationApplication : Application() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
        // Verifica se a versão do Android é Oreo ou superior
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val warningChannel = NotificationChannel(
                "notification_channel_id",
                "Nome da notificação",
                NotificationManager.IMPORTANCE_HIGH
            )
            val warningManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            // Configurando o canal
            warningManager.createNotificationChannel(warningChannel)
        }
    }
}
