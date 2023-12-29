package com.foldrajzappok.fcminjetpackcompose.model

import androidx.lifecycle.ViewModel

class AuthViewModel(val authRepository: AuthRepository = AuthRepository()) : ViewModel()  {

    fun storeFCMToken(token: String) {
        authRepository.storeFCMToken(token)
    }

    fun loadFriends(): List<Friend>{
        //code here to get the friends
        return listOf()
    }

}