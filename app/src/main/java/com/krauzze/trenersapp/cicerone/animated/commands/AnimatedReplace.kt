package com.krauzze.trenersapp.cicerone.animated.commands

import com.krauzze.trenersapp.cicerone.animated.AnimatedScreen
import com.krauzze.trenersapp.cicerone.animated.commands.AnimatedCommand
import ru.terrakok.cicerone.commands.Replace


class AnimatedReplace(val screen: AnimatedScreen) : Replace(screen), AnimatedCommand {
    override fun getAnimEnter(): Int = screen.getAnimEnter()
    override fun getAnimExit(): Int = screen.getAnimExit()
    override fun getAnimPopEnter(): Int = screen.getAnimPopEnter()
    override fun getAnimPopExit(): Int = screen.getAnimPopExit()
}