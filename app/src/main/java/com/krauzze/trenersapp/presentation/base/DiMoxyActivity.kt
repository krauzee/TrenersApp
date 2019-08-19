package com.krauzze.trenersapp.presentation.base

import android.support.v4.app.Fragment
import com.krauzze.trenersapp.R
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class DiMoxyActivity : MoxyActivity(), HasSupportFragmentInjector {

    var backPressedListener: BackPressedInterface? = null

    abstract val containerId: Int

    @field:Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    /*override fun onBackPressed() {
        backPressedListener?.onBackPressed()
    }*/

    interface BackPressedInterface {
        fun onBackPressed()
    }

    open fun showRootLoad() {}

    open fun hideRootLoad() {}

    private fun back(): Boolean {
        return if (onBackPressedInternal())
            true
        else
            onHomeAsUp()
    }

    protected open fun onHomeAsUp(): Boolean {
        return false
    }

    final override fun onBackPressed() {
        back()
    }

    open fun onBackPressedInternal(): Boolean {
        val fragment = supportFragmentManager.findFragmentById(R.id.main_content)
        return if (fragment is MoxyFragment) {
            fragment.onBackPressed()
        } else {
            false
        }
    }
}