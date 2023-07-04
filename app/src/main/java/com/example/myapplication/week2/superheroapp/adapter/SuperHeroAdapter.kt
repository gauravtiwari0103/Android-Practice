package com.example.myapplication.week2.superheroapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.example.SuperHero
import com.example.myapplication.R
import com.example.myapplication.week2.superheroapp.SuperHeroDetails
import com.example.myapplication.week2.superheroapp.Utils


class SuperHeroAdapter(private val context:Context, private val dataSet: ArrayList<SuperHero>) :
    RecyclerView.Adapter<SuperHeroAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
     inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgView: ImageView
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View
            imgView = view.findViewById(R.id.super_card_img)
            textView = view.findViewById(R.id.super_card_title)
            view.setOnClickListener {
                val intent = Intent(context, SuperHeroDetails::class.java)
                intent.putExtra("hero", Utils.convertHeroToString(dataSet[adapterPosition]))
                context.startActivity(intent)
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.single_card_item_superhero, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        viewHolder.textView.text = dataSet[position].name
        val imgView = viewHolder.imgView
        Glide.with(context).load(dataSet[position].image?.url).into(imgView)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
