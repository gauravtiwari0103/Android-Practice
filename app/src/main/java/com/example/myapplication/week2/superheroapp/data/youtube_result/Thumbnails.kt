package com.example.myapplication.week2.superheroapp.data.youtube_result

import com.google.gson.annotations.SerializedName


data class Thumbnails (

  @SerializedName("default" ) var default : Default? = Default(),
  @SerializedName("medium"  ) var medium  : Medium?  = Medium(),
  @SerializedName("high"    ) var high    : High?    = High()

)