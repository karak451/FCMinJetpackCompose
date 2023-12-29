package com.foldrajzappok.fcminjetpackcompose.assistance.receiveNotification

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FCMService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        //in that case make an update of the user instance in the database
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // ...

        // Check if message contains a data payload.
        if (remoteMessage.data.isNotEmpty()) {
            val title = remoteMessage.data["title"].toString()
            val body = remoteMessage.data["body"].toString()
            MyNotification(applicationContext, title, body).fireNotification()
        }

        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            MyNotification(
                applicationContext,
                it.title.toString(),
                it.body.toString()
            ).fireNotification()
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }


}