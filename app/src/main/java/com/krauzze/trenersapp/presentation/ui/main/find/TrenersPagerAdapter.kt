package com.krauzze.trenersapp.presentation.ui.main.find

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.krauzze.trenersapp.R

class TrenersPagerAdapter : PagerAdapter() {

    var treners: List<String> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //val trener = treners[position]

        val inflater = LayoutInflater.from(container.context)
        val layout = inflater.inflate(R.layout.layout_trener_page, container, false)

        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return 5
    }
}