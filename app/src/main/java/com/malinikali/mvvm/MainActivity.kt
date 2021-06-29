package com.malinikali.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.malinikali.mvvm.databinding.ActivityMainBinding
import com.malinikali.mvvm.interfaces.LoginResultCallbacks
import com.malinikali.mvvm.viewModels.LoginViewModel
import com.malinikali.mvvm.viewModels.LoginViewModelFactory
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity(), LoginResultCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProviders.of(this,LoginViewModelFactory(this))
            .get(LoginViewModel::class.java)

    }

    override fun onSuccess(message: String) {
        Toasty.success(this,"Success", Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toasty.success(this,"Error", Toast.LENGTH_SHORT).show()
    }
}