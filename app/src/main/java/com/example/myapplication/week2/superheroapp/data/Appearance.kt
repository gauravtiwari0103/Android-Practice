package com.example.myapplication.week2.superheroapp.data

import com.google.gson.annotations.SerializedName


data class Appearance (

  @SerializedName("gender"     ) var gender     : String?           = null,
  @SerializedName("race"       ) var race       : String?           = null,
  @SerializedName("height"     ) var height     : ArrayList<String> = arrayListOf(),
  @SerializedName("weight"     ) var weight     : ArrayList<String> = arrayListOf(),
  @SerializedName("eye-color"  ) var eye_color  : String?= null,
  @SerializedName("hair-color" ) var hair_color : String?           = null

)