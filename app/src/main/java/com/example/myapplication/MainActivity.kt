package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.week2.superheroapp.SuperheroActivity
import com.example.myapplication.week1.SharedPreferenceDemo
import com.example.myapplication.week2.learingfragments.FragmentActiviti
import com.example.myapplication.week2.learingviewpager.ViewPager2Activiti
import com.example.myapplication.week2.learningRetroFit.NewsActivity
import com.example.myapplication.week2.learning_navigation_controller.NaviagtionActivity
import com.example.myapplication.week2.volleyimplementation.VolleyActivity
import com.example.myapplication.week3.broadcastRecivers.BroadcastReciverDemo
import com.example.myapplication.week3.contentProviderDemo.ContentProviderDemo
import com.example.myapplication.week3.indiana_pacers_ui.Login

class MainActivity : AppCompatActivity() {
    private lateinit var btnChoiceSharedPreference:Button
    private lateinit var btnChoiceFragmentsDemo: Button
    private lateinit var btnChoiceViewPager2: Button
    private lateinit var btnChoiceNavigationController:Button
    private lateinit var btnChoiceRetrofitDemo: Button
    private lateinit var btnChoiceRetrofitDemo2:Button
    private lateinit var btnChoiceVolleyDemo: Button
    private lateinit var btnChoiceIndianaPacersUI: Button
    private lateinit var btnChoiceBroadCastRecieverDemo: Button
    private lateinit var btnChoiceContentProviderDemo: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setOnClickListners()
    }

    private fun setOnClickListners(){
        btnChoiceSharedPreference.setOnClickListener {
            startActivity(Intent(this@MainActivity, SharedPreferenceDemo::class.java))
        }
        btnChoiceFragmentsDemo.setOnClickListener {
            startActivity(Intent(this@MainActivity, FragmentActiviti::class.java))
        }
        btnChoiceViewPager2.setOnClickListener {
            startActivity(Intent(this@MainActivity, ViewPager2Activiti::class.java))
        }
        btnChoiceNavigationController.setOnClickListener {
            startActivity(Intent(this@MainActivity, NaviagtionActivity::class.java))
        }
        btnChoiceRetrofitDemo.setOnClickListener {
            startActivity(Intent(this@MainActivity, NewsActivity::class.java))
        }
        btnChoiceRetrofitDemo2.setOnClickListener {
            startActivity(Intent(this@MainActivity, SuperheroActivity::class.java))
        }
        btnChoiceVolleyDemo.setOnClickListener {
            startActivity(Intent(this@MainActivity, VolleyActivity::class.java))
        }
        btnChoiceIndianaPacersUI.setOnClickListener {
            startActivity(Intent(this@MainActivity, Login::class.java))
        }
        btnChoiceBroadCastRecieverDemo.setOnClickListener {
            startActivity(Intent(this@MainActivity, BroadcastReciverDemo::class.java))
        }
        btnChoiceContentProviderDemo.setOnClickListener {
            startActivity(Intent(this@MainActivity, ContentProviderDemo::class.java))
        }


    }

    private fun initViews(){
        btnChoiceSharedPreference = findViewById(R.id.btnChoiceSharedPreference)
        btnChoiceFragmentsDemo = findViewById(R.id.btnChoiceFragmentsDemo)
        btnChoiceViewPager2 = findViewById(R.id.btnChoiceViewPager)
        btnChoiceNavigationController = findViewById(R.id.btnChoiceNavigationController)
        btnChoiceRetrofitDemo = findViewById(R.id.btnChoiceRetrofitDemo)
        btnChoiceRetrofitDemo2= findViewById(R.id.btnChoiceRetrofitDemo2)
        btnChoiceVolleyDemo = findViewById(R.id.btnChoiceVolleyDemo)
        btnChoiceIndianaPacersUI = findViewById(R.id.btnChoiceIndianaPacersUi)
        btnChoiceBroadCastRecieverDemo = findViewById(R.id.btnChoiceBroadCastRecieverDemo)
        btnChoiceContentProviderDemo = findViewById(R.id.btnChoiceContentProviderDemo)
    }
}