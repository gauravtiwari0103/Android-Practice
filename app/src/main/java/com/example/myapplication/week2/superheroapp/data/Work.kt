package com.example.example

import com.google.gson.annotations.SerializedName


data class Work (

  @SerializedName("occupation" ) var occupation : String? = null,
  @SerializedName("base"       ) var base       : String? = null

)