package com.example.myapplication.week3.indiana_pacers_ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.week3.indiana_pacers_ui.PlayerStats
import com.example.myapplication.week3.indiana_pacers_ui.data.Player


class PlayerListAdapter(private val context: Context, private val dataSet: ArrayList<Player>) :
    RecyclerView.Adapter<PlayerListAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val playername: TextView
        val playerNo : TextView
        val playerImg : ImageView
        val playerPosition: TextView

        init {
            playername = view.findViewById(R.id.pacer_listCard_tv_playerName)
            playerNo = view.findViewById(R.id.pacer_listcard_tv_jerseyno)
            playerImg = view.findViewById(R.id.pacer_iv_ListCardPlayerImg)
            playerPosition = view.findViewById(R.id.pacer_listCard_tv_playerposition)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.pacer_single_item_playerlist_card, viewGroup, false)
        view.setOnClickListener {
            context.startActivity(Intent(context, PlayerStats::class.java))
        }
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.playername.text = dataSet[position].name
        viewHolder.playerPosition.text = dataSet[position].position
        viewHolder.playerNo.text = dataSet[position].no
        viewHolder.playerImg.setImageResource(dataSet[position].img)
    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
