package com.example.myapplication.week3.indiana_pacers_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.week3.indiana_pacers_ui.adapter.PlayerListAdapter
import com.example.myapplication.week3.indiana_pacers_ui.data.Player
import com.example.myapplication.week3.indiana_pacers_ui.data.player_models.Players
import com.example.myapplication.week3.indiana_pacers_ui.interfaces.DfeApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

class PlayerList : AppCompatActivity() {
    private lateinit var tvAppbarTitle: TextView
    private lateinit var rv: RecyclerView
    private lateinit var iv_BackButton: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_list)
        initViews()
        tvAppbarTitle.setText("Roaster")

        GlobalScope.launch {
            val response = DfeApiService.apiInstance.getPlayers().awaitResponse()
            Log.d("tag912","In global scope")
            if(response.isSuccessful){
                var list :ArrayList<Players> = response!!.body()!!.data!!.players!!
                Log.d("tag912","response successful $list")
                withContext(Dispatchers.Main){
                    rv.adapter = PlayerListAdapter(this@PlayerList, list)
                }

            }
        }

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