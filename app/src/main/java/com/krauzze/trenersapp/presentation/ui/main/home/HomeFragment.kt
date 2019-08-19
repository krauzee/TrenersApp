package com.krauzze.trenersapp.presentation.ui.main.home

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.krauzze.trenersapp.R
import com.krauzze.trenersapp.presentation.base.DiMoxyFragment
import javax.inject.Inject
import javax.inject.Provider

class HomeFragment: DiMoxyFragment(), HomeView {

    companion object {
        fun getInstance() = HomeFragment()
    }

    @Inject
    lateinit var presenterProvider: Provider<HomePresenter>

    @InjectPresenter
    lateinit var presenter: HomePresenter

    @ProvidePresenter
    fun providePresenter() = presenterProvider.get()

    override val layout = R.layout.fragment_home
}