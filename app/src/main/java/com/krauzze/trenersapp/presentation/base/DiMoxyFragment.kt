package com.krauzze.trenersapp.presentation.base

import android.content.Context
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class DiMoxyFragment : MoxyFragment(), HasSupportFragmentInjector, FragmentMvpInterface {

    @field:Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

}