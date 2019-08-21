package com.krauzze.trenersapp.presentation.ui.main.find

import com.arellomobile.mvp.InjectViewState
import com.krauzze.trenersapp.presentation.base.MoxyPresenter
import org.jsoup.Jsoup
import javax.inject.Inject
import kotlin.concurrent.thread

@InjectViewState
class FindPresenter @Inject constructor() : MoxyPresenter<FindView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadTrenersList()
    }

    private fun loadTrenersList() {

    }

}