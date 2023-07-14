package com.example.myapplication.week4.livedata_and_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.R

class LiveDataViewModel : AppCompatActivity() {
    private lateinit var btn:Button
    private lateinit var et: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata_viewmodel)
        initViews()
        var ld = MutableLiveData<String>();
        ld.observe(this){
            Toast.makeText(this,"value changed to ${ld.value}", Toast.LENGTH_LONG).show()
        }

        btn.setOnClickListener {
            val text = et.text.toString()
            ld.value = text
            Log.d("tag912","List: ${ld.value}")
        }


        var ldd : LiveData<ArrayList<String>> = MutableLiveData<ArrayList<String>>()


    }

    fun initViews(){
        btn = findViewById(R.id.liveData_btn)
        et = findViewById(R.id.liveData_et)
    }
}