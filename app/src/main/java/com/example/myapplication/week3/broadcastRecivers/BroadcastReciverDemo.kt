package com.example.myapplication.week3.broadcastRecivers

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R

class BroadcastReciverDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static_broadcast_reciver_demo)

        val intentFilter : IntentFilter  = IntentFilter()
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        registerReceiver(MyBroadCastReceiver(), intentFilter)
    }
}