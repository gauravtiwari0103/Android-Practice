package com.example.myapplication.week2.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.example.SuperHero
import com.example.myapplication.R
import com.example.myapplication.week2.superheroapp.adapter.YoutubeAdapter
import com.example.myapplication.week2.superheroapp.data.youtube_result.Items
import com.example.myapplication.week2.superheroapp.data.youtube_result.YoutubeResult
import com.example.myapplication.week2.superheroapp.interfaces.YoutubeService
import com.google.android.material.appbar.CollapsingToolbarLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder

class SuperHeroDetails : AppCompatActivity() {
    private lateinit var hero:SuperHero
    private lateinit var listOfVideos:ArrayList<Items>

    private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
    private lateinit var img: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvGender: TextView
    private lateinit var tvHeight: TextView
    private lateinit var tvWeight: TextView
    private lateinit var tvIntelligence: TextView
    private lateinit var tvStrength: TextView
    private lateinit var tvSpeed: TextView
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero_details)
        initVariables()
        initViews()
        bindDataWithViews()
        Toast.makeText(this, hero.name.toString(), Toast.LENGTH_LONG).show()
        setUpClips()





    }

    fun setUpClips(){
        var sb:StringBuilder = StringBuilder()
        var heroName = hero.name
        for(char in heroName!!){
            if(char==' '){
                sb.append("%20")
            }
            else sb.append(char)
        }
        sb.append("%20superhero%20clips")
        var query = sb.toString()


        //retrofit work starts here
        val youtube:Call<YoutubeResult> = YoutubeService.youtubeServiceInstance.getVideos(q=query)
        youtube.enqueue(object:Callback<YoutubeResult>{
            override fun onFailure(call: Call<YoutubeResult>, t: Throwable) {
                Log.d("tag912","failded to fetch results")
            }

            override fun onResponse(call: Call<YoutubeResult>, response: Response<YoutubeResult>) {
                val responseYoutubeResult = response.body()
                if (responseYoutubeResult != null) {
                    listOfVideos = responseYoutubeResult.items
                    rv.adapter = YoutubeAdapter(this@SuperHeroDetails, listOfVideos)
                    rv.layoutManager = LinearLayoutManager(this@SuperHeroDetails)
                }

                Log.d("tag912",responseYoutubeResult.toString())
            }
        })
    }

    fun bindDataWithViews(){
        collapsingToolbarLayout.title = hero.name
        Glide.with(this).load(hero.image?.url).into(img)
        tvName.text = hero.name
        tvGender.text = hero.appearance?.gender ?: "None"
        tvHeight.text = hero.appearance?.height?.get(0) ?: "Unknown"
        tvWeight.text = hero.appearance?.weight?.get(0) ?: "Unknown"
        tvIntelligence.text = hero.powerstats?.intelligence ?: "Unknown"
        tvStrength.text = hero.powerstats?.strength ?: "Unknown"
        tvSpeed.text = hero.powerstats?.speed ?: "Unknown"


    }

    fun initVariables(){
        hero = Utils.convertJsonStringToHero(intent.getStringExtra("hero")!!)
    }

    fun initViews(){
        collapsingToolbarLayout = findViewById(R.id.superDetailsCollaspingToolbar)
        img = findViewById(R.id.superDetailImage)
        tvName = findViewById(R.id.superdetailsname)
        tvGender= findViewById(R.id.superdetailsGender)
        tvHeight = findViewById(R.id.superDetailsHeight)
        tvWeight = findViewById(R.id.superDetailsWeight)
        tvIntelligence = findViewById(R.id.superDetailsIntelligence)
        tvStrength = findViewById(R.id.movieDetailsStrength)
        tvSpeed = findViewById(R.id.superDetailsSpeed)
        rv = findViewById(R.id.superDetailsRv)
    }
}