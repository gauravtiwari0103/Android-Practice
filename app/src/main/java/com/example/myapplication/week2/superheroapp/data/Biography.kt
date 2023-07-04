package com.example.myapplication.week2.superheroapp.data

import com.google.gson.annotations.SerializedName


data class Biography (

  @SerializedName("full-name"        ) var full_name        : String?           = null,
  @SerializedName("alter-egos"       ) var alter_egos       : String?           = null,
  @SerializedName("aliases"          ) var aliases          : ArrayList<String> = arrayListOf(),
  @SerializedName("place-of-birth"   ) var place_of_birth   : String?           = null,
  @SerializedName("first-appearance" ) var first_appearance : String?           = null,
  @SerializedName("publisher"        ) var publisher        : String?           = null,
  @SerializedName("alignment"        ) var alignment        : String?           = null

)