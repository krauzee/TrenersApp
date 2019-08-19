package com.krauzze.trenersapp.presentation.ui.main.notif

import android.support.v4.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class NotifScreen: SupportAppScreen() {

    override fun getFragment(): Fragment {
        return NotifFragment.getInstance()
    }

    override fun getScreenKey(): String {
        return "${NotifFragment::class}"
    }
}