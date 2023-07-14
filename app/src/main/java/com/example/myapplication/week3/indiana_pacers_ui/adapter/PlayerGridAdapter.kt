package com.example.myapplication.week3.indiana_pacers_ui.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.week3.indiana_pacers_ui.PlayerStats
import com.example.myapplication.week3.indiana_pacers_ui.data.Player
import com.example.myapplication.week3.indiana_pacers_ui.data.player_models.Players

class PlayerGridAdapter(private val context: Context, private val playerList: ArrayList<Players>) : BaseAdapter() {

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
//        viewHolder.playerImage.setImageResource(player.img)
        Glide.with(context).load(player.headshotImageUrl).placeholder(R.drawable.dummy_player_list).into(viewHolder.playerImage)
        var nameToShow = "${player.fn} ${player.ln}"
        if (nameToShow.length > 14){
            nameToShow = "${player.fn} ${player.ln!!.get(0)}"
        }
        viewHolder.playerName.text = nameToShow
        viewHolder.playerNumber.text = player.jerseyNum
        viewHolder.playerPosition.text = player.posFull
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
