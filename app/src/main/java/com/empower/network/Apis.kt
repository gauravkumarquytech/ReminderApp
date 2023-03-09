package com.empower.network


import com.empower.dashboard.TripSheetResponse
import com.empower.login.LoginResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface Apis {

    @POST("login")
    suspend fun login(): Response<LoginResponseModel>

    @GET("api/Tripsheet/DocketCartonListByTripsheet")
    suspend fun pickupRequest(@QueryMap body: Map<String, String>): TripSheetResponse

    /*@POST("signup")
    suspend fun signup(@Body signupRequestModel: SignupRequestModel): Response<SignUpResponseModel>

    @POST("verify-otp")
    suspend fun verifyOTP(@Body otpVerificationRequestModel: OTPVerificationRequestModel): Response<OTPVerificationResponseModel>

    @POST("login")
    suspend fun login(@Body request: LoginRequestModel): Response<LoginResponseModel>

    @POST("forgot-password")
    suspend fun forgotPassword(@Body request: ForgotRequestModel): Response<ForgotResponseModel>

    @POST("reset-password")
    suspend fun resetPassword(@Body request: ResetPasswordRequestModel): Response<ResetPasswordResponseModel>

    @POST("resend-otp")
    fun resendOTP(@Body request: ResendOTPRequestModel): Response<ResendOTPResponseModel>

    @GET("")
    suspend fun getHomePageData(): Response<DashboardResponseModel>*/
}