package com.example.notifications_collapse_expand_remoteview

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ev.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        bt1.setOnClickListener {
            var cv = RemoteViews(packageName, R.layout.cv)
            var ev = RemoteViews(packageName, R.layout.ev)

            ev.setImageViewResource(R.id.iv, R.drawable.cover)
            ev.setOnClickPendingIntent(
                R.id.iv,
                PendingIntent.getActivity(this, 0, Intent(this, MainActivity::class.java), 0)
            )

            var n = NotificationCompat.Builder(this, App.id)
                .setCustomContentView(cv)
                .setCustomBigContentView(ev)
                .build()
            var nm = NotificationManagerCompat.from(this)
            nm.notify(1, n)
        }
    }
}
