package com.krauzze.trenersapp.presentation.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.IdRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatDialogFragment
import dagger.android.support.AndroidSupportInjection
import com.krauzze.trenersapp.log.Logger
import com.krauzze.trenersapp.util.SnackbarFactory
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

abstract class MoxyDialogFragment : MvpAppCompatDialogFragment(), BaseView {

    companion object {
        private const val TAG = "MoxyDialogFragment"
    }

    protected abstract val layout: Int

    @field:Inject
    lateinit var snackbarFactory: SnackbarFactory

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Logger.v(TAG) {
            "${javaClass.name} - onCreateView()"
        }
        return inflater.inflate(layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onViewPrepare(savedInstanceState)
    }

    protected fun initScreen(@IdRes containerId: Int, screen: SupportAppScreen) {
        childFragmentManager.beginTransaction()
                .add(containerId, screen.fragment)
                .addToBackStack(screen.screenKey)
                .commit()
    }


    override fun showErrorSnackbar(error: String) {
        snackbarFactory.getErrorSnackbar(requireNotNull(view), error).show()
    }
    override fun showErrorSnackbar(error: Int) {
        snackbarFactory.getErrorSnackbar(requireNotNull(view), error).show()
    }

    override fun showSnackbar(text: String) {
        snackbarFactory.getSnackbar(requireNotNull(view), text).show()
    }
    override fun showSnackbar(text: Int) {
        snackbarFactory.getSnackbar(requireNotNull(view), text).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Logger.v(TAG) {
            "${javaClass.name} - onDestroyView()"
        }
    }

    protected open fun onViewPrepare(savedInstanceState: Bundle?) {

    }

}