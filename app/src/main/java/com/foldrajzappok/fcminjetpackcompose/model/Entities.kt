package com.foldrajzappok.fcminjetpackcompose.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Friend(
    @PrimaryKey(autoGenerate = true) var friend_id: Int = 0,
    var friend_name: String,
    var friend_token: String,
)