package com.krauzze.trenersapp.presentation.base

import android.os.Bundle
import android.support.annotation.IdRes
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.krauzze.trenersapp.FixAndroidInjection
import com.krauzze.trenersapp.log.Logger
import com.krauzze.trenersapp.util.SnackbarFactory
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

abstract class MoxyActivity : MvpAppCompatActivity(), BaseView {

    companion object {
        private const val TAG = "MoxyActivity"
    }

    protected abstract val layout: Int

    @field:Inject
    lateinit var snackbarFactory: SnackbarFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        FixAndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        Logger.v(TAG) {
            "${javaClass.name} - onCreate()"
        }
        setContentView(layout)
        onViewPrepare(savedInstanceState)
    }

    private fun getRoot(): View = window.decorView.findViewById<View>(android.R.id.content)

    override fun showErrorSnackbar(error: Int) {
        snackbarFactory.getErrorSnackbar(requireNotNull(getRoot()), error).show()
    }

    override fun showErrorSnackbar(error: String) {
        snackbarFactory.getErrorSnackbar(requireNotNull(getRoot()), error).show()
    }

    override fun showSnackbar(text: String) {
        snackbarFactory.getSnackbar(requireNotNull(getRoot()), text)
    }

    override fun showSnackbar(text: Int) {
        snackbarFactory.getSnackbar(requireNotNull(getRoot()), text)
    }

    protected fun initScreen(@IdRes containerId: Int, screen: SupportAppScreen) {
        supportFragmentManager.beginTransaction()
            .add(containerId, screen.fragment)
            .addToBackStack(screen.screenKey)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.v(TAG) {
            "${javaClass.name} - onDestroy()"
        }
    }

    protected open fun onViewPrepare(savedInstanceState: Bundle?) {

    }

}