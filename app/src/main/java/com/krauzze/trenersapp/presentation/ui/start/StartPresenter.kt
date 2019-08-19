package com.krauzze.trenersapp.presentation.ui.start

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.krauzze.trenersapp.cicerone.screens.ScreenFactory
import com.krauzze.trenersapp.presentation.ui.RootQualifier
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class StartPresenter @Inject constructor() : MvpPresenter<StartView>() {

    @field:RootQualifier
    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Handler().postDelayed({router.newRootScreen(ScreenFactory.getMainScreen())}, 2000)
    }

}