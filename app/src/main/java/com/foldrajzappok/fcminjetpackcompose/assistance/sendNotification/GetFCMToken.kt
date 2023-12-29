package com.foldrajzappok.fcminjetpackcompose.assistance.sendNotification

import android.content.ContentValues
import android.util.Log
import com.foldrajzappok.fcminjetpackcompose.model.AuthViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

fun GetFCMToken(avm: AuthViewModel) {
    FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
        if (!task.isSuccessful) {
            Log.w(ContentValues.TAG, "Fetching FCM registration token failed", task.exception)
            return@OnCompleteListener
        }

        // Get new FCM registration token
        val token = task.result

        // Store
        avm.storeFCMToken(token)

    })
}