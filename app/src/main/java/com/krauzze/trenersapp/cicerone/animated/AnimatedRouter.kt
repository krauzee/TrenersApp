package com.krauzze.trenersapp.cicerone.animated

import com.krauzze.trenersapp.cicerone.animated.commands.AnimatedForward
import com.krauzze.trenersapp.cicerone.animated.commands.AnimatedReplace
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.commands.BackTo

open class AnimatedRouter : Router() {

    override fun navigateTo(screen: Screen?) {
        if (screen is AnimatedScreen) {
            executeCommands(AnimatedForward(screen))
        } else super.navigateTo(screen)
    }

    override fun replaceScreen(screen: Screen?) {
        if (screen is AnimatedScreen) {
            executeCommands(AnimatedReplace(screen))
        } else super.replaceScreen(screen)
    }

    override fun newRootScreen(screen: Screen?) {
        if (screen is AnimatedScreen) {
            executeCommands(
                BackTo(null),
                AnimatedReplace(screen)
            )
        } else super.newRootScreen(screen)
    }


}