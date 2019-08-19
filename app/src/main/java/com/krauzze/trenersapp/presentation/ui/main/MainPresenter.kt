package com.krauzze.trenersapp.presentation.ui.main

import com.arellomobile.mvp.InjectViewState
import com.krauzze.trenersapp.presentation.base.MoxyPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor() : MoxyPresenter<MainView>() {

    @Inject
    @field:MainQualifier
    lateinit var router: Router

    fun onCreate(isRestore: Boolean) {
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

}