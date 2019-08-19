package com.krauzze.trenersapp.cicerone.animated.commands

import com.krauzze.trenersapp.cicerone.animated.AnimatedScreen
import ru.terrakok.cicerone.commands.Forward

open class AnimatedForward(val screen: AnimatedScreen) : Forward(screen), AnimatedCommand {
    override fun getAnimEnter(): Int = screen.getAnimEnter()
    override fun getAnimExit(): Int = screen.getAnimExit()
    override fun getAnimPopEnter(): Int = screen.getAnimPopEnter()
    override fun getAnimPopExit(): Int = screen.getAnimPopExit()
}