package com.example.myapplication.week3.indiana_pacers_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.week3.indiana_pacers_ui.adapter.PlayerHorizontalAdapter

class HorizontalList : AppCompatActivity() {
    private lateinit var tvTitle : TextView
    private lateinit var rv: RecyclerView
    private lateinit var iv_backButton: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal_list)
        initView()
        tvTitle.text = "Roaster"
        rv.adapter = PlayerHorizontalAdapter(this, ListOfPlayers.listOfPlayer)
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        iv_backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    fun initView(){
        tvTitle = findViewById(R.id.pacer_tv_appbar)
        rv = findViewById(R.id.pacer_horizontal_rv)
        iv_backButton = findViewById(R.id.pacer_appbar_iv_backbutton)
    }
}