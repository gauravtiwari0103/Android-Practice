package com.example.myapplication.week4.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.provider.Settings.Global
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class CoroutinesDemo : AppCompatActivity() {

    private val TAG = "tag912"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_demo)



        GlobalScope.launch(Dispatchers.Main){
            val res1 = async { nwcall1() }
            val res2 = async { nwcall2() }
        }


    }

    suspend fun nwcall1(){
        delay(3000)

        Log.d(TAG, "${Thread.currentThread().id}Nw call 1 done")
    }
    suspend fun nwcall2(){
        delay(3000)
        Log.d(TAG, "${Thread.currentThread().id}Nw call 2 done")
    }
    suspend fun getNetworkCallResult(): String {
        delay(1000L)
        return "Got the result"
    }
}