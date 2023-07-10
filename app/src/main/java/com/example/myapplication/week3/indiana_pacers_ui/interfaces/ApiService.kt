package com.example.myapplication.week3.indiana_pacers_ui.interfaces

import com.example.myapplication.week3.indiana_pacers_ui.data.RegisterApiResponse
import com.example.myapplication.week3.indiana_pacers_ui.data.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.POST

const val BASE_URL = "https://fe50-115-247-52-210.ngrok-free.app/"

interface ApiInterface {
    @POST("register")
    fun getToken(@Body body:User):Call<RegisterApiResponse>
}

object ApiService{

    val apiInstance: ApiInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInstance = retrofit.create(ApiInterface::class.java)
    }
}