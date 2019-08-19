package com.krauzze.trenersapp.presentation.ui.start

import android.animation.*
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.krauzze.trenersapp.R
import com.krauzze.trenersapp.presentation.base.DiMoxyFragment
import javax.inject.Inject
import javax.inject.Provider

class StartFragment : DiMoxyFragment(), StartView {

    companion object {
        fun getInstance() = StartFragment()
    }

    @Inject
    lateinit var presenterProvider: Provider<StartPresenter>

    @InjectPresenter
    lateinit var presenter: StartPresenter

    @ProvidePresenter
    fun providePresenter(): StartPresenter = presenterProvider.get()


    private val fadeInSignIn by lazy {
        AnimatorInflater.loadAnimator(context, R.animator.fade_in).setDuration(1500)
    }
    private val fadeInSignOut by lazy {
        AnimatorInflater.loadAnimator(context, R.animator.fade_in).setDuration(1500)
    }

    override val layout = R.layout.fragment_start_screen

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)

    }



    override fun onViewDestroyed() {
        super.onViewDestroyed()
        if (fadeInSignIn.isRunning)
            fadeInSignIn.cancel()
        if (fadeInSignOut.isRunning)
            fadeInSignOut.cancel()
    }

}