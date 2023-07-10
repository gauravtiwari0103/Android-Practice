package com.example.myapplication.week3.indiana_pacers_ui.interfaces

import com.example.myapplication.week3.indiana_pacers_ui.data.LoginCredential
import com.example.myapplication.week3.indiana_pacers_ui.data.UserLoginResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiLogin {
    @POST("email-login")
    fun loginWithCredential(@Body loginCredential: LoginCredential): Call<UserLoginResponse>
}

object LoginService{
    val apiLoginInstance: ApiLogin
    val BASE_URL: String = "https://fe50-115-247-52-210.ngrok-free.app/"
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiLoginInstance = retrofit.create(ApiLogin::class.java)
    }
}