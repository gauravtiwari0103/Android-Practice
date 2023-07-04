package com.example.myapplication.week2.learningRetroFit.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.week2.learningRetroFit.data.Article


class NewsViewPagerAdapter(val context: Context,private val dataSet: ArrayList<Article>) :
    RecyclerView.Adapter<NewsViewPagerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgView: ImageView
        val publishedAt: TextView
        val author: TextView
        val title : TextView
        val content: TextView
        val description: TextView
        val btn: Button

        init {
            // Define click listener for the ViewHolder's View
            imgView = view.findViewById(R.id.retro_new_img)
            publishedAt = view.findViewById(R.id.retro_published_date)
            author = view.findViewById(R.id.retro_author)
            title = view.findViewById(R.id.retro_news_title)
            content = view.findViewById(R.id.retro_news_content)
            description = view.findViewById(R.id.retro_description)
            btn = view.findViewById(R.id.retro_btnViewMore)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.single_news_page, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.title.text = dataSet[position].title
        viewHolder.description.text = dataSet[position].description
        viewHolder.publishedAt.text = dataSet[position].publishedAt
        viewHolder.author.text = dataSet[position].author
        viewHolder.content.text = dataSet[position].content
        val imgView = viewHolder.imgView
        Glide.with(context).load(dataSet[position].urlToImage).into(imgView)
        viewHolder.btn.setOnClickListener {
            val url = dataSet[position].url
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            context.startActivity(i)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
