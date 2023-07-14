package com.example.myapplication.week4.flows

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.lang.Exception

class StopwatchActivity : AppCompatActivity() {
    private lateinit var tvTime:TextView
    private lateinit var etTime: EditText
    private lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)
        initViews()
        tvTime.visibility = View.GONE

        btnStart.setOnClickListener {
            startStopwatch()

        }


    }

    fun initViews(){
        tvTime = findViewById(R.id.flowTvTime)
        etTime = findViewById(R.id.flowEtTime)
        btnStart = findViewById(R.id.flowBtnStart)
    }


    private fun startStopwatch(){
        val time = etTime.text.toString().toInt()
        etTime.setText("")
        tvTime.text = "$time"
        tvTime.visibility = View.VISIBLE
        var timeEmitter = TimeEmitter.getEmitter(time)
        lifecycleScope.launch {
            timeEmitter.collect{ time->
                Log.d("tag912","reaching here $time")
                withContext(Dispatchers.Main){
                    val mp = MediaPlayer.create(this@StopwatchActivity, R.raw.tick_sound)
                    mp.start()
                    tvTime.text = time.toString()
                }


            }

        }
        Toast.makeText(this, "Stopwatch Ended",Toast.LENGTH_LONG).show()
    }

}