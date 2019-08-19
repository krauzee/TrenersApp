package com.krauzze.trenersapp.presentation.ui.main

import android.support.v4.app.Fragment
import com.krauzze.trenersapp.R
import com.krauzze.trenersapp.cicerone.animated.AnimatedScreen

class MainScreen internal constructor() : AnimatedScreen() {

    override fun getAnimEnter(): Int = R.anim.fragment_def

    override fun getAnimExit(): Int = R.anim.fragment_def

    override fun getAnimPopEnter(): Int = R.anim.fragment_def

    override fun getAnimPopExit(): Int = R.anim.fragment_def

    override fun getFragment(): Fragment {
        return MainFragment.getInstance()
    }

    override fun getScreenKey(): String {
        return "${MainFragment::class}"
    }

}