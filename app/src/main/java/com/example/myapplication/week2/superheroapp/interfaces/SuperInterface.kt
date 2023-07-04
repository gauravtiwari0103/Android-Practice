package com.example.myapplication.week2.superheroapp.interfaces

import com.example.example.SuperHero
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


const val BASE_URL = "https://superheroapi.com/api/"
const val API_KEY = "3067057400266160"

interface SuperInterface {
    @GET("$API_KEY/{id}")
    fun getSuperHero(@Path("id") id: String) : Call<SuperHero>
}

object SuperHeroService{
    val superHeroGetterInstance: SuperInterface
    init {
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        superHeroGetterInstance = retrofit.create(SuperInterface::class.java)
    }
}