package com.tuf2000m.energymeter.views.authentication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.tuf2000m.energymeter.data.model.auth.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val auth: FirebaseAuth
) : ViewModel() {

    private val _isLoginMode = MutableLiveData(true)
    val isLoginMode: LiveData<Boolean> get() = _isLoginMode

    // Function to handle account creation
    fun createAccount(email: String, password: String): LiveData<AuthResult> {
        val result = MutableLiveData<AuthResult>()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    result.value = AuthResult.Success(auth.currentUser)
                } else {
                    result.value = AuthResult.Failure(task.exception)
                }
            }
        return result
    }

    // Function to handle sign in
    fun signIn(email: String, password: String): LiveData<AuthResult> {
        val result = MutableLiveData<AuthResult>()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    result.value = AuthResult.Success(auth.currentUser)
                } else {
                    result.value = AuthResult.Failure(task.exception)
                }
            }
        return result

    }

    fun toggleLoginSignupMode() {
        _isLoginMode.value = !_isLoginMode.value!!
    }

}
