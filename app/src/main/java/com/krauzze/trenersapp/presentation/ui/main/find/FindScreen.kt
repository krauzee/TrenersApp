package com.krauzze.trenersapp.presentation.ui.main.find

import android.support.v4.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class FindScreen internal constructor() : SupportAppScreen() {

    override fun getFragment(): Fragment {
        return FindFragment.getInstance()
    }

    override fun getScreenKey(): String {
        return "${FindFragment::class}"
    }
}