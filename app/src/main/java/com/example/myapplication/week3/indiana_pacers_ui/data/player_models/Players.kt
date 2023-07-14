package com.example.myapplication.week3.indiana_pacers_ui.data.player_models

import com.google.gson.annotations.SerializedName


data class Players (

    @SerializedName("uid"                ) var uid              : String?         = null,
    @SerializedName("year"               ) var year             : Int?            = null,
    @SerializedName("season_id"          ) var seasonId         : String?         = null,
    @SerializedName("league_id"          ) var leagueId         : String?         = null,
    @SerializedName("tid"                ) var tid              : String?         = null,
    @SerializedName("pid"                ) var pid              : String?         = null,
    @SerializedName("fn"                 ) var fn               : String?         = null,
    @SerializedName("ln"                 ) var ln               : String?         = null,
    @SerializedName("pc"                 ) var pc               : String?         = null,
    @SerializedName("jersey_num"         ) var jerseyNum        : String?         = null,
    @SerializedName("num"                ) var num              : Int?            = null,
    @SerializedName("pos"                ) var pos              : String?         = null,
    @SerializedName("pos_full"           ) var posFull          : String?         = null,
    @SerializedName("dob"                ) var dob              : String?         = null,
    @SerializedName("age"                ) var age              : Int?            = null,
    @SerializedName("ht"                 ) var ht               : String?         = null,
    @SerializedName("wt"                 ) var wt               : Int?            = null,
    @SerializedName("y"                  ) var y                : Int?            = null,
    @SerializedName("sn"                 ) var sn               : String?         = null,
    @SerializedName("ty"                 ) var ty               : String?         = null,
    @SerializedName("ta"                 ) var ta               : String?         = null,
    @SerializedName("tc"                 ) var tc               : String?         = null,
    @SerializedName("co"                 ) var co               : String?         = null,
    @SerializedName("la"                 ) var la               : String?         = null,
    @SerializedName("dy"                 ) var dy               : String?         = null,
    @SerializedName("fa"                 ) var fa               : String?         = null,
    @SerializedName("s"                  ) var s                : String?         = null,
    @SerializedName("headshot_image_url" ) var headshotImageUrl : String?         = null,
    @SerializedName("action_image_url"   ) var actionImageUrl   : String?         = null,
    @SerializedName("wt_lbs"             ) var wtLbs            : String?         = null,
    @SerializedName("hide"               ) var hide             : Boolean?        = null,
    @SerializedName("bio"                ) var bio              : String?         = null,
    @SerializedName("order"              ) var order            : String?         = null,
    @SerializedName("custom_fields"      ) var customFields     : String?         = null,
    @SerializedName("template_fields"    ) var templateFields   : TemplateFields? = TemplateFields(),
    @SerializedName("cs_custom_fields"   ) var csCustomFields   : String?         = null,
    @SerializedName("isSelected"   ) var isSelected   : Boolean = false
)