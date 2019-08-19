package com.krauzze.trenersapp.cicerone.screens

import com.krauzze.trenersapp.presentation.ui.main.MainScreen
import com.krauzze.trenersapp.presentation.ui.main.find.FindScreen
import com.krauzze.trenersapp.presentation.ui.start.StartScreen
import ru.terrakok.cicerone.Screen

object ScreenFactory {

    fun getMainScreen(): Screen = MainScreen()

    fun getStartScreen(): Screen = StartScreen()

    fun getFindScreen(): Screen = FindScreen()

}
