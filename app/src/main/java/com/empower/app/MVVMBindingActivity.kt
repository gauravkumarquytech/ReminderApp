package com.empower.app

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.empower.common.SharedPreference


abstract class MVVMBindingActivity<B> : AppCompatActivity() {
    protected var binding: B? = null
    protected lateinit var sharedPreference: SharedPreference

    //protected var viewModel :V? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreference = SharedPreference(this)
        binding = DataBindingUtil.setContentView(this, provideViewResource())
        //val viewModel: V by  provideViewModel() { ViewModalFactoryClass(application) }
        //viewModel = ViewModelProvider(this, ViewModalFactoryClass(application)).get(provideViewModel())
        initializeView()
    }

    abstract fun initializeView()

    abstract fun provideViewResource(): Int

    fun onBackArrow(backArrow: ImageView) {
        backArrow.setOnClickListener {
            finish()
        }
    }


    fun showToast(message:String){
        Toast.makeText(
            this@MVVMBindingActivity,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }


}