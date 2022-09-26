package com.example.shopapp.data.repository

import com.example.shopapp.data.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface IAuthRepository {

    fun registerUser(email: String, password: String): Task<AuthResult>

    fun addNewUser(user: User)
    fun loginUser(email: String, password: String): Task<AuthResult>
}