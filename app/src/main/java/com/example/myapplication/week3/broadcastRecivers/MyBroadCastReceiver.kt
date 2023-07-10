package com.example.myapplication.week3.broadcastRecivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
//        if (intent != null) {
            Toast.makeText(context,"Airphonemode clicked${intent!!.action} ",Toast.LENGTH_LONG).show()
//        }
    }
}