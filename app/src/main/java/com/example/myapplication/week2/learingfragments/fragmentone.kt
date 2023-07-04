package com.example.myapplication.week2.learingfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragmentone.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragmentone : Fragment(R.layout.fragment_fragmentone) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvFragmentOneText : TextView = view.findViewById(R.id.tvFragmentOne)
        tvFragmentOneText.setOnClickListener {
            Toast.makeText(context, "Clicked on fragment one text", Toast.LENGTH_SHORT).show()
        }
    }

}