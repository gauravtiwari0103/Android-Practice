package com.example.myapplication.week3.indiana_pacers_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R

class Welcome : AppCompatActivity() {
    private lateinit var tv_heading: TextView
    private lateinit var tvPlayerList:TextView
    private lateinit var tvPlayerGrid:TextView
    private lateinit var tvPlayerListHorizontal: TextView
    private lateinit var btnLogout : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        initView()
        val firstName = intent.getStringExtra("firstname")
        tv_heading.setText(Html.fromHtml("Welcome <font color=#FFB71B>$firstName</font>"))

        tvPlayerList.setOnClickListener {
            val intent = Intent(this, PlayerList::class.java)
            startActivity(intent)
        }
        tvPlayerGrid.setOnClickListener {
            val intent = Intent(this, PlayerGrid::class.java)
            startActivity(intent)
        }

        tvPlayerListHorizontal.setOnClickListener {
            val intent = Intent(this, HorizontalList::class.java)
            startActivity(intent)
        }
        btnLogout.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
    fun initView(){
        tv_heading = findViewById(R.id.pacers_tv_welcome_heading)
        tvPlayerList = findViewById(R.id.pacers_welcome_tv_playerlist)
        tvPlayerGrid = findViewById(R.id.pacers_welcome_tv_playergrid)
        tvPlayerListHorizontal = findViewById(R.id.pacers_welcome_tv_playerListHorizontal)
        btnLogout = findViewById(R.id.pacers_welcome_btn_logout)

    }
}