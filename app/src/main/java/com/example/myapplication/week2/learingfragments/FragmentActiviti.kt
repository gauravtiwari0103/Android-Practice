package com.example.myapplication.week2.learingfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class FragmentActiviti : AppCompatActivity() {

    private lateinit var btnFragmentOne: Button
    private lateinit var btnFragmentTwo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_activiti)

        btnFragmentOne  = findViewById(R.id.btnFragmentOne)
        btnFragmentTwo = findViewById(R.id.btnFragmentTwo)

        btnFragmentOne.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragmentone())
                commit()
            }
        }

        btnFragmentTwo.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, FragmentTwo())
                commit()
            }
        }


    }
}