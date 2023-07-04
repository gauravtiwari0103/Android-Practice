package com.example.myapplication.week2.superheroapp.data.youtube_result

import com.example.myapplication.week2.superheroapp.data.youtube_result.Items
import com.example.myapplication.week2.superheroapp.data.youtube_result.PageInfo
import com.google.gson.annotations.SerializedName


data class YoutubeResult (

  @SerializedName("kind"          ) var kind          : String?          = null,
  @SerializedName("etag"          ) var etag          : String?          = null,
  @SerializedName("nextPageToken" ) var nextPageToken : String?          = null,
  @SerializedName("regionCode"    ) var regionCode    : String?          = null,
  @SerializedName("pageInfo"      ) var pageInfo      : PageInfo?        = PageInfo(0,0),
  @SerializedName("items"         ) var items         : ArrayList<Items> = arrayListOf()

)