package com.foldrajzappok.fcminjetpackcompose

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.foldrajzappok.fcminjetpackcompose.model.AuthViewModel
import com.foldrajzappok.fcminjetpackcompose.assistance.sendNotification.GetFCMToken
import com.foldrajzappok.fcminjetpackcompose.assistance.Navigation
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FCMinJCApp : Application()

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {

            val avm = AuthViewModel()
            GetFCMToken(avm) //get the token in order to Firebase can identify the target device of your message

            Navigation(avm)

        }
    }
}