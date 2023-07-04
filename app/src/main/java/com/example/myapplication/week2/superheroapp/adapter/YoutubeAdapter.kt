package com.example.myapplication.week2.superheroapp.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.week2.superheroapp.data.youtube_result.Items


class YoutubeAdapter(private val context: Context, private val dataSet: ArrayList<Items>) :
    RecyclerView.Adapter<YoutubeAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgView: ImageView
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View
            imgView = view.findViewById(R.id.superDetailsYoutubeCardImageView)
            textView = view.findViewById(R.id.superDetailsYoutubeCardTextView)
            view.setOnClickListener {
                val videoId = dataSet[adapterPosition].id?.videoId
                val url = "https://www.youtube.com/watch?v=${videoId}"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                context.startActivity(i)
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.single_youtubecard_item_superherodetailspage, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        viewHolder.textView.text = dataSet[position].snippet?.title ?: "None"
        val imgView = viewHolder.imgView
        val thumbnailLink = dataSet[position].snippet?.thumbnails?.high?.url
        Glide.with(context).load(thumbnailLink).into(imgView)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
