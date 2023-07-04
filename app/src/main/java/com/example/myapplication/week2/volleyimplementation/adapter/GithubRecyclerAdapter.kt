package com.example.myapplication.week2.volleyimplementation.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.week2.volleyimplementation.data.GithubUser


class GithubRecyclerAdapter(private val context:Context,private val dataSet: ArrayList<GithubUser>) :
    RecyclerView.Adapter<GithubRecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val btn: Button
        val imgView: ImageView

        init {
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.volley_github_username)
            btn = view.findViewById(R.id.volley_gihub_openprofilebtn)
            imgView = view.findViewById(R.id.volley_github_img)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.single_item_githubuser, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet[position].login
        viewHolder.btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            val url = dataSet[position].html_url
            intent.setData(Uri.parse(url))
            context.startActivity(intent)
        }
        val imgUrl = dataSet[position].avatar_url
        Glide.with(context).load(imgUrl).into(viewHolder.imgView)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
