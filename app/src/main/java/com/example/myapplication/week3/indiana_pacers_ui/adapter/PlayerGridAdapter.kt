package com.example.myapplication.week3.indiana_pacers_ui.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.week3.indiana_pacers_ui.PlayerStats
import com.example.myapplication.week3.indiana_pacers_ui.data.Player

class PlayerGridAdapter(private val context: Context, private val playerList: ArrayList<Player>) : BaseAdapter() {

    override fun getCount(): Int {
        return playerList.size
    }

    override fun getItem(position: Int): Any {
        return playerList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.pacer_singleitem_playergrid_card, parent, false)
            viewHolder = ViewHolder()
            viewHolder.playerImage = view.findViewById(R.id.pacers_playerGrid_card_ivImg)
            viewHolder.playerName = view.findViewById(R.id.pacers_playerGrid_card_tvname)
            viewHolder.playerNumber = view.findViewById(R.id.pacers_playerGrid_card_tvno)
            viewHolder.playerPosition = view.findViewById(R.id.pacers_playerGrid_card_tvposition)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        val player = playerList[position]
        viewHolder.playerImage.setImageResource(player.img)
        viewHolder.playerName.text = player.name
        viewHolder.playerNumber.text = player.no
        viewHolder.playerPosition.text = player.position
        view.setOnClickListener {
            context.startActivity(Intent(context, PlayerStats::class.java))
        }
        return view
    }

    private class ViewHolder {
        lateinit var playerImage: ImageView
        lateinit var playerName: TextView
        lateinit var playerNumber: TextView
        lateinit var playerPosition: TextView
    }
}
