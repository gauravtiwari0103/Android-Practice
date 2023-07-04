package com.example.myapplication.week2.superheroapp.interfaces

import com.example.myapplication.week2.superheroapp.data.youtube_result.YoutubeResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.lang.StringBuilder

//https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=20&q=IronMan%20Vs%20Captain%20America&type=video&key=AIzaSyBDLAL6Dp5ke5jf453PQWfUdMbZTVQUBWA

const val BASE_URL_FOR_YOUTUBE = "https://www.googleapis.com/youtube/"
const val API_KEY_FOR_YOUTUBE = "AIzaSyBDLAL6Dp5ke5jf453PQWfUdMbZTVQUBWA"
interface YoutubeInterface {

    @GET("v3/search?key=$API_KEY_FOR_YOUTUBE")
    fun getVideos(
        @Query("part") snippet: String ="snippet",
        @Query("maxResults") maxResults:String ="20",
        @Query("q") q:String,
        @Query("type") type:String="type",
        @Query("safeSearch") safeSearch:String="moderate"
    ): Call<YoutubeResult>
}

object YoutubeService{
    val youtubeServiceInstance: YoutubeInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_FOR_YOUTUBE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        youtubeServiceInstance = retrofit.create(YoutubeInterface::class.java)
    }
}