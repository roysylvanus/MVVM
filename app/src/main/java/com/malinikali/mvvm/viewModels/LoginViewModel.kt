package com.malinikali.mvvm.viewModels

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.malinikali.mvvm.interfaces.LoginResultCallbacks
import com.malinikali.mvvm.models.User

class LoginViewModel(private val listener:LoginResultCallbacks): ViewModel() {

    private val user:User

    init {
        this.user = User("","")
    }

    //create function to set email after user finishes entering text
    val emailTextWatcher:TextWatcher
    get() = object:TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            user?.setEmail(s.toString())
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
        }

    }

    //create function to set password after user finishes entering text

    val passwordTextWatcher:TextWatcher
        get() = object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                user?.setPassword(s.toString())
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
            }

        }


    //create function to process login button on clicked

    fun onLoginClicked(v: View){
        if(user.isDataValid){
            listener.onSuccess("Login success")
        } else
            listener.onError("Login error")
    }
}