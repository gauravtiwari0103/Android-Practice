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
import com.example.myapplication.week3.indiana_pacers_ui.adapter.PlayerListAdapter
import com.example.myapplication.week3.indiana_pacers_ui.data.player_models.Players
import com.example.myapplication.week3.indiana_pacers_ui.interfaces.DfeApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

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

        GlobalScope.launch {
            val response = DfeApiService.apiInstance.getPlayers().awaitResponse()
            if(response.isSuccessful){
                var list :ArrayList<Players> = response!!.body()!!.data!!.players!!
                withContext(Dispatchers.Main){
                    gv.adapter = PlayerGridAdapter(this@PlayerGrid, list)
                }

            }
        }

    }

    fun initViews(){
        tvTitle = findViewById(R.id.pacer_tv_appbar)
        gv = findViewById(R.id.pacers_playerGrid_gv)
        iv_BackButton = findViewById(R.id.pacer_appbar_iv_backbutton)
    }
}