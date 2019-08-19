package com.krauzze.trenersapp.presentation.ui.main.find

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.krauzze.trenersapp.R

/**
 * Created by Александр on 21.03.2019.
 */

class TrenersListAdapter : RecyclerView.Adapter<TrenersListAdapter.PrayerViewHolder>() {
    var prayerList: MutableList<Triple<String, String, String>> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_trener_page, parent, false)
        return PrayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PrayerViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class PrayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal fun bind(position: Int) {
            //val prayer = prayerList[position]

        }
    }
}