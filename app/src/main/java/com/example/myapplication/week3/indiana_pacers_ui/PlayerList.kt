package com.example.myapplication.week3.indiana_pacers_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.week3.indiana_pacers_ui.adapter.PlayerListAdapter
import com.example.myapplication.week3.indiana_pacers_ui.data.Player

class PlayerList : AppCompatActivity() {
    private lateinit var tvAppbarTitle: TextView
    private lateinit var rv: RecyclerView
    private lateinit var iv_BackButton: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_list)
        initViews()
        tvAppbarTitle.setText("Roaster")

        rv.adapter = PlayerListAdapter(this, ListOfPlayers.listOfPlayer)
        rv.layoutManager = LinearLayoutManager(this)

        iv_BackButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }



    }

    private fun initViews(){
        tvAppbarTitle = findViewById(R.id.pacer_tv_appbar)
        rv = findViewById(R.id.pacers_playerlist_rv)
        iv_BackButton = findViewById(R.id.pacer_appbar_iv_backbutton)
    }
}