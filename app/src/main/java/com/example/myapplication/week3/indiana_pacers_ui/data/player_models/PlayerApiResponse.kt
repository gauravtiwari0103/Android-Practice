package com.example.myapplication.week3.indiana_pacers_ui.data.player_models

import com.google.gson.annotations.SerializedName


data class PlayerApiResponse (

    @SerializedName("data" ) var data : Data? = Data()

)