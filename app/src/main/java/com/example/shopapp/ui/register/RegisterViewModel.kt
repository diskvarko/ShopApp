package com.example.shopapp.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopapp.data.User
import com.example.shopapp.data.repository.IAuthRepository
import com.example.shopapp.domain.ValidationResult
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authRepository: IAuthRepository) : ViewModel() {

    private val _validateName = MutableLiveData<ValidationResult>()
    val validateName: LiveData<ValidationResult> = _validateName

    fun registerUser(email: String, password: String): Task<AuthResult> {
        return authRepository.registerUser(email, password)
    }

    fun addNewUser(user: User) {
        authRepository.addNewUser(user)
    }

    private fun validateName(inputText: String) {
        if (validateEmpty(inputText)) {
            _validateName.value = ValidationResult.EMPTY_FIELD
        }
    }

    private fun validateEmpty(inputText: String): Boolean {
        return inputText.isEmpty()
    }
}