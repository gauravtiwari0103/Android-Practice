package com.example.myapplication.week2.superheroapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.example.SuperHero
import com.example.myapplication.R
import com.example.myapplication.week2.superheroapp.adapter.SuperHeroAdapter
import com.example.myapplication.week2.superheroapp.interfaces.SuperHeroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class SuperheroActivity : AppCompatActivity() {
    private lateinit var listOfHeros: ArrayList<SuperHero>
    private lateinit var rv: RecyclerView
    private lateinit var sharedPreference: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)
        initVariables()
        initViews()
        setUpRecyclerView()
        if(sharedPreference.contains("listOfHeros")){
            listOfHeros = Utils.convertJsonStringToList(sharedPreference.getString("listOfHeros","")!!)
            setUpRecyclerView()
        }
        else{
            getSuperHero(1)
        }

    }
    private val SUPERHERSHAREDPREFERENCE = "SUPERHEROSHAREDPREFERENCE"

    fun initVariables(){
        listOfHeros = ArrayList()
        sharedPreference = getSharedPreferences(SUPERHERSHAREDPREFERENCE, Context.MODE_PRIVATE)
        editor = sharedPreference.edit()
    }

    fun initViews(){
        rv = findViewById(R.id.super_rv)
    }


    fun setUpRecyclerView(){
        rv.adapter = SuperHeroAdapter(this@SuperheroActivity, listOfHeros)
        rv.layoutManager = GridLayoutManager(this@SuperheroActivity, 2)


    }

    fun getSuperHero(id:Int){
        val superHero: Call<SuperHero> = SuperHeroService.superHeroGetterInstance.getSuperHero(id.toString())
        superHero.enqueue(object : Callback<SuperHero>{
            override fun onFailure(call: Call<SuperHero>, t: Throwable) {
                Log.d("tag912","Error fetching superhero data for id: $id")


            }

            override fun onResponse(call: Call<SuperHero>, response: Response<SuperHero>) {
                val superHero = response.body()

                if(superHero!=null){
                    Log.d("tag912", superHero.toString())
                    if(superHero.id == null || superHero.id=="null"){
                        val listToString = Utils.convertListToString(listOfHeros)
                        editor.apply {
                            putString("listOfHeros", listToString)
                            apply()
                        }

                    }
                    else{
                        listOfHeros.add(superHero)
                        rv.adapter?.notifyItemInserted(listOfHeros.size-1)
                        getSuperHero(id+1)
                    }

                }
            }
        })
    }


}