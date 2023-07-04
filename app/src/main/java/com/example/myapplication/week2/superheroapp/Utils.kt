package com.example.myapplication.week2.superheroapp

import com.example.example.SuperHero
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Utils {
    val gson: Gson = Gson()
    public fun convertListToString(list: ArrayList<SuperHero>): String {
        return gson.toJson(list)
    }

    public fun convertHeroToString(obj: SuperHero):String{
        return gson.toJson(obj)
    }

    public fun convertJsonStringToHero(str:String): SuperHero{
        val taskType = object : TypeToken<SuperHero>() {}.type
        return gson.fromJson(str, taskType)
    }

    public fun convertJsonStringToList(str: String): ArrayList<SuperHero>{
        val taskListType = object : TypeToken<ArrayList<SuperHero>>() {}.type
        return gson.fromJson(str, taskListType)
    }
}