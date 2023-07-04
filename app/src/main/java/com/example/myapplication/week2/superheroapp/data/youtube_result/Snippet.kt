package com.example.myapplication.week2.superheroapp.data.youtube_result

import com.example.myapplication.week2.superheroapp.data.youtube_result.Thumbnails
import com.google.gson.annotations.SerializedName


data class Snippet (

  @SerializedName("publishedAt"          ) var publishedAt          : String?     = null,
  @SerializedName("channelId"            ) var channelId            : String?     = null,
  @SerializedName("title"                ) var title                : String?     = null,
  @SerializedName("description"          ) var description          : String?     = null,
  @SerializedName("thumbnails"           ) var thumbnails           : Thumbnails? = Thumbnails(),
  @SerializedName("channelTitle"         ) var channelTitle         : String?     = null,
  @SerializedName("liveBroadcastContent" ) var liveBroadcastContent : String?     = null,
  @SerializedName("publishTime"          ) var publishTime          : String?     = null

)