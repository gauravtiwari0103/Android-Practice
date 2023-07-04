package com.example.myapplication.week2.superheroapp.data.youtube_result

import com.google.gson.annotations.SerializedName


data class Id (

  @SerializedName("kind"    ) var kind    : String? = null,
  @SerializedName("videoId" ) var videoId : String? = null

)