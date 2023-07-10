package com.example.myapplication.week3.indiana_pacers_ui.data

import com.google.gson.annotations.SerializedName

data class UserLoginResponse (

    @SerializedName("status"  ) var status  : String? = null,
    @SerializedName("message" ) var message : String? = null,
    @SerializedName("token"   ) var token   : String? = null,
    @SerializedName("userId"  ) var userId  : String? = null,
    @SerializedName("email"   ) var email   : String? = null,
    @SerializedName("fname"   ) var fname   : String? = null,
    @SerializedName("lname"   ) var lname   : String? = null

)