package com.foldrajzappok.fcminjetpackcompose.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.foldrajzappok.fcminjetpackcompose.assistance.sendNotification.callMessageSendingFunction
import com.foldrajzappok.fcminjetpackcompose.model.AuthViewModel
import com.foldrajzappok.fcminjetpackcompose.model.Friend

@Composable
fun StartScreen(
    navController: NavController,
    avm: AuthViewModel
) {

    val userName =
        "user" //in order to focus on FCM, in this example project there is no detailed data handling
    val friends: List<Friend> = avm.loadFriends()
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = friends, itemContent = { item ->
            Text(
                text = "Send a static message to ${item.friend_name}",
                modifier = Modifier
                    .clickable {
                        callMessageSendingFunction(
                            text = "$userName notifies you via this message",
                            tokenOfRecepientUser = item.friend_token,
                            delivered = {
                                Toast.makeText(
                                    context,
                                    "Message sent to ${item.friend_name}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        )
                    }
            )
        })
    }

}