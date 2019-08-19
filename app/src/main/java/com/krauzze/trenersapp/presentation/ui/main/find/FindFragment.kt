package com.krauzze.trenersapp.presentation.ui.main.find

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.krauzze.trenersapp.R
import com.krauzze.trenersapp.presentation.base.DiMoxyFragment
import javax.inject.Inject
import javax.inject.Provider

class FindFragment: DiMoxyFragment(), FindView {

    companion object {
        fun getInstance() = FindFragment()
    }

    @Inject
    lateinit var presenterProvider: Provider<FindPresenter>

    @InjectPresenter
    lateinit var presenter: FindPresenter

    @ProvidePresenter
    fun providePresenter() = presenterProvider.get()

    override val layout = R.layout.fragment_find
}