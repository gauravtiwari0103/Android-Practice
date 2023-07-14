package com.example.myapplication.week3.indiana_pacers_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.week3.indiana_pacers_ui.adapter.PlayerHorizontalAdapter
import com.example.myapplication.week3.indiana_pacers_ui.interfaces.DfeApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

class HorizontalList : AppCompatActivity() {
    private lateinit var tvTitle : TextView
    private lateinit var rv: RecyclerView
    private lateinit var iv_backButton: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal_list)
        initView()
        tvTitle.text = "Roaster"
        doNewtowrkCall()
//        rv.adapter = PlayerHorizontalAdapter(this, ListOfPlayers.listOfPlayer)
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        iv_backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun doNewtowrkCall() {
        lifecycleScope.launch {
            val response = DfeApiService.apiInstance.getPlayers().awaitResponse()
            val list = response.body()!!.data!!.players
            withContext(Dispatchers.Main){
                rv.adapter = PlayerHorizontalAdapter(this@HorizontalList, list)
            }
        }
    }

    fun initView(){
        tvTitle = findViewById(R.id.pacer_tv_appbar)
        rv = findViewById(R.id.pacer_horizontal_rv)
        iv_backButton = findViewById(R.id.pacer_appbar_iv_backbutton)
    }
}