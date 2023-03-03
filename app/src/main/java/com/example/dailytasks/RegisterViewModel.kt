package com.example.dailytasks

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    val loginUsername: MutableLiveData<String?> = MutableLiveData()
    val loginPassword: MutableLiveData<String?> = MutableLiveData()
    val signupUsername: MutableLiveData<String?> = MutableLiveData()
    val signupPassword: MutableLiveData<String?> = MutableLiveData()
    fun updateDataLogin(username: String, password: String) {
        loginUsername.value = username
        loginPassword.value = password
    }

    fun updateDataSignup(username: String, password: String) {
        signupUsername.value = username
        signupPassword.value = password
    }


    fun isNull(): MutableLiveData<Boolean> =
        MutableLiveData(signupUsername.value == null || signupUsername.value == "" || signupPassword.value == null || signupPassword.value == "")

    fun isCorrect(): Boolean =
        loginPassword.value == signupPassword.value && loginUsername.value == signupUsername.value

    fun makeToast(toast: Toast) {
        toast.show()
    }


}