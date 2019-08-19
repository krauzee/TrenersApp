package com.krauzze.trenersapp.presentation.ui.main.notif

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.krauzze.trenersapp.R
import com.krauzze.trenersapp.presentation.base.DiMoxyFragment
import javax.inject.Inject
import javax.inject.Provider

class NotifFragment: DiMoxyFragment(), NotifView {

    companion object {
        fun getInstance() = NotifFragment()
    }

    @Inject
    lateinit var presenterProvider: Provider<NotifPresenter>

    @InjectPresenter
    lateinit var presenter: NotifPresenter

    @ProvidePresenter
    fun providePresenter() = presenterProvider.get()

    override val layout = R.layout.fragment_notify
}