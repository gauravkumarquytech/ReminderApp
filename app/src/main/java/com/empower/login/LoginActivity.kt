package com.empower.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.empower.R
import com.empower.app.MVVMBindingActivity
import com.empower.dashboard.MainActivity
import com.empower.databinding.ActivityLoginBinding

class LoginActivity : MVVMBindingActivity<ActivityLoginBinding>() {

    override fun initializeView() {
        binding?.run {
            submit.setOnClickListener {
                startActivity(Intent(this@LoginActivity,MainActivity::class.java))
            }
        }
    }

    override fun provideViewResource(): Int {
       return R.layout.activity_login
    }
}