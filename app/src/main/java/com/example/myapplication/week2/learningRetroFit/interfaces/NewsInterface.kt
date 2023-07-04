package com.example.myapplication.week2.learningRetroFit.interfaces

import com.example.myapplication.week2.learningRetroFit.data.Article
import com.example.myapplication.week2.learningRetroFit.data.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query



//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=2e4bb9edd3ae4ed197144be999f1959b
const val BASE_URL = "https://newsapi.org/v2/"
const val API_KEY = "2e4bb9edd3ae4ed197144be999f1959b"

interface NewsInterface {

    @GET("top-headlines?apiKey=$API_KEY")
    fun getNews(@Query("country") country: String):Call<News>

}

object NewsService{
    val newsInstance : NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}