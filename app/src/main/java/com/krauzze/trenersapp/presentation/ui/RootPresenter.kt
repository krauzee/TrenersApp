package com.krauzze.trenersapp.presentation.ui

import com.arellomobile.mvp.InjectViewState
import com.krauzze.trenersapp.cicerone.screens.ScreenFactory
import com.krauzze.trenersapp.presentation.base.MoxyPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class RootPresenter @Inject constructor() : MoxyPresenter<RootView>() {

    @field:RootQualifier
    @field:Inject
    lateinit var router: Router


    fun onCreate(isRestore: Boolean) {
        router.newRootScreen(ScreenFactory.getStartScreen())
    }




}