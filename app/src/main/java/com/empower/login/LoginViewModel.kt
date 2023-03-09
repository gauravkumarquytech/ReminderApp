package com.empower.login

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.empower.R
import com.empower.network.Resource
import com.empower.utils.Utils
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(var app: Application) : ViewModel() {
    @SuppressLint("StaticFieldLeak")
    private var mContext: Context = app.applicationContext
    private val repository = LoginRepository()
    private var mLoginResponseModel = MutableLiveData<Resource<LoginResponseModel>>()
    var loginResponseModel: LiveData<Resource<LoginResponseModel>> = mLoginResponseModel

    fun login() {
        if (Utils.hasInternetConnection(mContext)) {
            viewModelScope.launch {
                val response = repository.login()
                mLoginResponseModel.value = response?.let { handleLoginResponse(it) }
            }
        } else mLoginResponseModel.value =
            Resource.Error(app.resources.getString(R.string.no_internet))
    }

    private fun handleLoginResponse(response: Response<LoginResponseModel>): Resource<LoginResponseModel>? {
        if (response.isSuccessful) {
            response.body()?.let {
                return when (response.code()) {
                    200 -> Resource.Success(it.FlagMessage)
                    else -> Resource.Error(it.FlagMessage)
                }
            }
        }
        return Resource.Error(response.message())
    }
}