package com.example.myapplication.week3.indiana_pacers_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.week3.indiana_pacers_ui.adapter.PlayerGridAdapter

class PlayerGrid : AppCompatActivity() {
    private lateinit var tvTitle:TextView
    private lateinit var gv: GridView
    private lateinit var iv_BackButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_grid)
        initViews()

        iv_BackButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        tvTitle.text= "Roaster"

        gv.adapter = PlayerGridAdapter(this, ListOfPlayers.listOfPlayer)

    }

    fun initViews(){
        tvTitle = findViewById(R.id.pacer_tv_appbar)
        gv = findViewById(R.id.pacers_playerGrid_gv)
        iv_BackButton = findViewById(R.id.pacer_appbar_iv_backbutton)
    }
}