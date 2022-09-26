package com.example.shopapp.data.repository

import com.example.shopapp.data.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AuthRepository(private val firebaseAuth: FirebaseAuth, private val firebaseFirestore: FirebaseFirestore) :
    IAuthRepository {

    override fun registerUser(email: String, password: String): Task<AuthResult> {
        return firebaseAuth.createUserWithEmailAndPassword(email, password)
    }

    override fun addNewUser(user: User) {
        firebaseFirestore.collection("users")
            .document(firebaseAuth.currentUser!!.uid)
            .set(user)
    }

    override fun loginUser(email: String, password: String): Task<AuthResult> {
        return firebaseAuth.signInWithEmailAndPassword(email, password)
    }

}

