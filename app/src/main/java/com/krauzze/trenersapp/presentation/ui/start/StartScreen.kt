package com.krauzze.trenersapp.presentation.ui.start

import android.support.v4.app.Fragment
import com.krauzze.trenersapp.R
import com.krauzze.trenersapp.cicerone.animated.AnimatedScreen

class StartScreen internal constructor() : AnimatedScreen() {

    override fun getAnimEnter(): Int = R.anim.fragment_from_end_to_start

    override fun getAnimPopEnter(): Int = R.anim.fragment_from_left_to_start

    override fun getFragment(): Fragment {
        return StartFragment.getInstance()
    }

    override fun getScreenKey(): String {
        return "${StartFragment::class}"
    }

}