package com.example.myapplication.week2.superheroapp.data

import com.google.gson.annotations.SerializedName


data class Connections (

  @SerializedName("group-affiliation" ) var group_affiliation : String? = null,
  @SerializedName("relatives"         ) var relatives         : String? = null

)