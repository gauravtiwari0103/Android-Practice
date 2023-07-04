package com.example.example

import com.example.myapplication.week2.superheroapp.data.Appearance
import com.example.myapplication.week2.superheroapp.data.Biography
import com.example.myapplication.week2.superheroapp.data.Connections
import com.google.gson.annotations.SerializedName


data class SuperHero (

  @SerializedName("response"    ) var response    : String?      = null,
  @SerializedName("id"          ) var id          : String?      = null,
  @SerializedName("name"        ) var name        : String?      = null,
  @SerializedName("powerstats"  ) var powerstats  : Powerstats?  = Powerstats(),
  @SerializedName("biography"   ) var biography   : Biography?   = Biography(),
  @SerializedName("appearance"  ) var appearance  : Appearance?  = Appearance(),
  @SerializedName("work"        ) var work        : Work?        = Work(),
  @SerializedName("connections" ) var connections : Connections? = Connections(),
  @SerializedName("image"       ) var image       : Image?       = Image()

)