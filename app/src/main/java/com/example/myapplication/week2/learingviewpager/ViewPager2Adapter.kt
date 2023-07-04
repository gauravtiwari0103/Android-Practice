package com.example.myapplication.week2.learingviewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class ViewPager2Adapter(var list:  List<Int>):
RecyclerView.Adapter<ViewPager2Adapter.ViewPagerViewHolder>(){

    inner class ViewPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager2,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.itemView.findViewById<ImageView>(R.id.vp_imgView).setImageResource(list[position])
    }
}