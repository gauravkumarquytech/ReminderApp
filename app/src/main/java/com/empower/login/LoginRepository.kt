package com.empower.login

import com.empower.network.RetrofitInstance


/**
 *Created by Gaurav Kumar on 7/28/2022
 * QUYTECH
 */
class LoginRepository {
    suspend fun login() = RetrofitInstance.apiService?.login()
}