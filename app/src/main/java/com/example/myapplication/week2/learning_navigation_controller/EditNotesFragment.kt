package com.example.myapplication.week2.learning_navigation_controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class EditNotesFragment : Fragment(R.layout.fragment_edit_notes) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context, "On Edit TExt", Toast.LENGTH_SHORT).show()
    }

}