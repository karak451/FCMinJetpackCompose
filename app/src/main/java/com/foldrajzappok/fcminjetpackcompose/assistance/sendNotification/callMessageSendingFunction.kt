package com.foldrajzappok.fcminjetpackcompose.assistance.sendNotification

import android.util.Log
import com.google.firebase.functions.FirebaseFunctions

fun callMessageSendingFunction(text: String, tokenOfRecepientUser: String, delivered: (Boolean) -> Unit) {
    val data = hashMapOf(
        "text" to text,
        "token" to tokenOfRecepientUser,
        "push" to true,
    )

    FirebaseFunctions.getInstance("europe-central2")
        .getHttpsCallable("messageSendingFunction")
        .call(data)
        .addOnFailureListener {
            Log.wtf("FCM", it)
        }
        .addOnSuccessListener {
            delivered.invoke(true)
        }
}