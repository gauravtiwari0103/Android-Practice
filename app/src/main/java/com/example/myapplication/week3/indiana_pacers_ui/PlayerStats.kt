package com.example.myapplication.week3.indiana_pacers_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.myapplication.R

class PlayerStats : AppCompatActivity() {
    private lateinit var cardViewBack:CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_stats)
        initViews()

        cardViewBack.setOnClickListener {
            finish()
        }
    }

    fun initViews(){
        cardViewBack = findViewById(R.id.pacers_playerstats_cardView_backbtn)
    }
}