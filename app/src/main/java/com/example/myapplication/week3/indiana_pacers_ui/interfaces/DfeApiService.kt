package com.example.myapplication.week3.indiana_pacers_ui.interfaces

import com.example.myapplication.week3.indiana_pacers_ui.data.RegisterApiResponse
import com.example.myapplication.week3.indiana_pacers_ui.data.User
import com.example.myapplication.week3.indiana_pacers_ui.data.player_models.PlayerApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.POST

const val DFE_BASE_URL = "https://api.digitalfanexperience.com/v1/nba/app/"


interface DfeApiInterface {
    @POST("graphql?device=android&version=4.0.0&Content-Type=application%2Fjson&sport_key=dfe5bedd98feb7282ca&env_key=dev&query=%7B%0A%09players(tid%3A\"1610612754\"%2Cleague_id%3A\"00\"%2Cyear%3A2022)%20%7B%0A%09%20%20uid%0A%09%20%20year%0A%09%20%20season_id%0A%09%20%20league_id%0A%09%20%20tid%0A%09%20%20pid%0A%09%20%20fn%0A%09%20%20ln%0A%09%20%20pc%0A%09%20%20jersey_num%0A%09%20%20num%0A%09%20%20pos%0A%09%20%20pos_full%0A%09%20%20dob%0A%09%20%20age%0A%09%20%20ht%0A%09%20%20wt%0A%09%20%20y%0A%09%20%20sn%0A%09%20%20ty%0A%09%20%20ta%0A%09%20%20tc%0A%09%20%20co%0A%09%20%20la%0A%09%20%20dy%0A%09%20%20fa%0A%09%20%20s%0A%09%20%20headshot_image_url%0A%09%20%20action_image_url%0A%09%20%20wt_lbs%0A%09%20%20hide%0A%09%20%20bio%0A%09%20%20order%0A%09%20%20custom_fields%0A%09%20%20template_fields%0A%09%20%20cs_custom_fields%0A%09%7D%0A%7D")
    fun getPlayers():Call<PlayerApiResponse>


}

object DfeApiService{

    val apiInstance: DfeApiInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(DFE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInstance = retrofit.create(DfeApiInterface::class.java)
    }
}