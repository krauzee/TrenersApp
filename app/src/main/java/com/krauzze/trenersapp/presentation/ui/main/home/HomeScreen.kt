package com.krauzze.trenersapp.presentation.ui.main.home

import android.support.v4.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class HomeScreen: SupportAppScreen() {

    override fun getFragment(): Fragment {
        return HomeFragment.getInstance()
    }

    override fun getScreenKey(): String {
        return "${HomeFragment::class}"
    }
}