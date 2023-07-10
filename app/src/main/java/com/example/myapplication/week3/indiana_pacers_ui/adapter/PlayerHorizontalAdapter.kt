package com.example.myapplication.week3.indiana_pacers_ui.adapter

import android.content.Context
import android.content.res.Resources
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.week3.indiana_pacers_ui.data.Player

class PlayerHorizontalAdapter(private val context: Context, private val playerList: ArrayList<Player>) :
    RecyclerView.Adapter<PlayerHorizontalAdapter.ViewHolder>() {

    private var prevSelection = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.pacer_single_item_playerlisthorizontal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = playerList[position]

        holder.playerName.text = player.name
        holder.playerImage.setImageResource(player.img)

        if (player.isSelected) {
            holder.card.layoutParams.height = (92 * Resources.getSystem().displayMetrics.density).toInt()
            holder.card.layoutParams.width = (92 * Resources.getSystem().displayMetrics.density).toInt()
            holder.playerName.visibility = View.GONE
            holder.playerImage.setBackgroundResource(R.drawable.pacer_horizontal_selected)
        } else {
            holder.card.layoutParams.height = (72 * Resources.getSystem().displayMetrics.density ).toInt()
            holder.card.layoutParams.width = (72 * Resources.getSystem().displayMetrics.density ).toInt()
            holder.playerImage.setBackgroundResource(R.drawable.pacer_horizontal_unselected)
            holder.playerName.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val playerName: TextView = itemView.findViewById(R.id.pacer_horizontalCard_tv)
        val playerImage: ImageView = itemView.findViewById(R.id.pacer_horizontalCard_img)
        val card: CardView  = itemView.findViewById(R.id.pacer_horizontalCard)

        init {



            itemView.setOnClickListener {
                if(prevSelection!=-1){
                    var prevPlayer = playerList[prevSelection]
                    prevPlayer.isSelected = false
                    notifyItemChanged(prevSelection)
                }
                prevSelection = adapterPosition
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val player = playerList[position]
                    player.isSelected = !player.isSelected
                    notifyItemChanged(position)
                }
            }
        }
    }
}
