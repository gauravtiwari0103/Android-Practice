package com.example.myapplication.week2.learingfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R

class FragmentTwo : Fragment(R.layout.fragment_two) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvFragmentTwoText: TextView = view.findViewById(R.id.tvFragmentTwo)
        tvFragmentTwoText.setOnClickListener {
            Toast.makeText(context, "Clicked on fragment two's textview", Toast.LENGTH_SHORT).show()
        }
    }
}