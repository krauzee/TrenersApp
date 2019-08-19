package com.krauzze.trenersapp.cicerone.animated

import android.content.Context
import android.content.Intent
import ru.terrakok.cicerone.android.support.SupportAppScreen

open class AnimatedScreen : SupportAppScreen() {
    open fun getAnimEnter(): Int = 0
    open fun getAnimExit(): Int = 0
    open fun getAnimPopEnter(): Int = 0
    open fun getAnimPopExit(): Int = 0

    final override fun getActivityIntent(context: Context?): Intent? {
        return super.getActivityIntent(context)
    }
}