package com.krauzze.trenersapp.cicerone.animated.commands

import ru.terrakok.cicerone.commands.Command

interface AnimatedCommand : Command{
    fun getAnimEnter(): Int
    fun getAnimExit(): Int
    fun getAnimPopEnter(): Int
    fun getAnimPopExit(): Int
}