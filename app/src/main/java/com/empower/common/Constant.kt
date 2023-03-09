package com.empower.common

/**
 *Created by Gaurav Kumar on 7/11/2022
 * QUYTECH
 */
object Constant {
    const val BASE_URL ="http://103.13.97.213/solex/"
    const val PREFS_NAME = "empower"
    const val MAC_ADDRESS = "mac_address"
    const val REQUEST_PERMISION =101
    object UserType{
        const val ADMIN = 1
        const val RETAILER = 2
        const val DISTRIBUTOR = 3
        const val MECHANIC = 4
        const val VEHICLE_OWNER = 5
    }

    object OTPVerificationIntentType{
        const val FORGOT_ACTIVITY = "forgot_activity"
        const val REGISTRATION_ACTIVITY = "registration_activity"
    }

}