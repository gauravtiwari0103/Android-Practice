package com.example.myapplication.week3.indiana_pacers_ui.data.player_models

import com.google.gson.annotations.SerializedName


data class Data (

    @SerializedName("players" ) var players : ArrayList<Players> = arrayListOf()

)