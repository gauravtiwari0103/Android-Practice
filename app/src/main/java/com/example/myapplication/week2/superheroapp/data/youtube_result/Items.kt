package com.example.myapplication.week2.superheroapp.data.youtube_result

import com.example.myapplication.week2.superheroapp.data.youtube_result.Snippet
import com.google.gson.annotations.SerializedName


data class Items (

  @SerializedName("kind"    ) var kind    : String?  = null,
  @SerializedName("etag"    ) var etag    : String?  = null,
  @SerializedName("id"      ) var id      : Id?      = Id(),
  @SerializedName("snippet" ) var snippet : Snippet? = Snippet()

)