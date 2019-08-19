package com.krauzze.trenersapp.presentation.ui.main.profile

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.krauzze.trenersapp.R
import com.krauzze.trenersapp.presentation.base.DiMoxyFragment
import javax.inject.Inject
import javax.inject.Provider

class ProfileFragment : DiMoxyFragment(), ProfileView {

    companion object {
        fun getInstance() = ProfileFragment()
    }

    @Inject
    lateinit var presenterProvider: Provider<ProfilePresenter>

    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    @ProvidePresenter
    fun providePresenter() = presenterProvider.get()

    override val layout = R.layout.fragment_profile
}