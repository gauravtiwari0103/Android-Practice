package com.example.myapplication.week2.learingviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R

class ViewPager2Activiti : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2_activiti)

        viewPager2 = findViewById(R.id.viewPager2)
        val list = listOf<Int>(
            R.drawable.kermit01,
            R.drawable.kermit02,
            R.drawable.kermit03,
            R.drawable.kermit04,
            R.drawable.kermit05,
            R.drawable.kermit06,
            R.drawable.kermit07,
            R.drawable.kermit08,
            R.drawable.kermit09,
            R.drawable.kermit10
        )
        viewPager2.adapter = ViewPager2Adapter(list)
        viewPager2.orientation = ViewPager2.ORIENTATION_VERTICAL



    }
}