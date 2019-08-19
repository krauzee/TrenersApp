package com.krauzze.trenersapp.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.krauzze.trenersapp.R
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import com.krauzze.trenersapp.log.Logger
import com.krauzze.trenersapp.presentation.ui.RootActivity
import com.krauzze.trenersapp.util.CustomDialog
import com.krauzze.trenersapp.util.SnackbarFactory
import javax.inject.Inject

abstract class MoxyFragment : MvpAppCompatFragment(), FragmentMvpInterface {

    companion object {
        private const val TAG = "MoxyFragment"
    }

    protected abstract val layout: Int
    private var viewCompositeDisposable: CompositeDisposable? = null

    @field:Inject
    lateinit var snackbarFactory: SnackbarFactory

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Logger.v(TAG) {
            "${javaClass.name} - onCreateView()"
        }
        viewCompositeDisposable = CompositeDisposable()
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isProvideEvent())
            view.setOnTouchListener { _, _ -> true }
    }

    protected open fun isProvideEvent(): Boolean = false

    final override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        applyTheme()
        onViewPrepare(savedInstanceState)
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

    protected fun applyTheme() {
        onApplyTheme()
    }

    protected open fun onApplyTheme() {}

    protected fun Disposable.disposeWith(compositeDisposable: CompositeDisposable) {
        compositeDisposable.add(this)
    }

    protected fun Disposable.disposeViewAction() {
        viewCompositeDisposable?.add(this)
    }

    override fun onDestroyView() {
        onViewDestroyed()
        viewCompositeDisposable?.dispose()
        super.onDestroyView()
        Logger.v(TAG) {
            "${javaClass.name} - onDestroyView()"
        }
    }


    override fun hideContent() {
        (activity as? RootActivity)?.hideContent()
    }

    override fun showContent() {
        (activity as? RootActivity)?.showContent()
    }

    override fun hideBackground() {
        (activity as? RootActivity)?.hideBackground()
    }

    override fun showBackground() {
        (activity as? RootActivity)?.showBackground()
    }

    override fun showProgress() {
        val activity = activity as? DiMoxyActivity
        activity?.showRootLoad()
    }

    override fun hideProgress() {
        val activity = activity as? DiMoxyActivity
        activity?.hideRootLoad()
    }

    protected fun showRootLoad() {
        val activity = activity as? DiMoxyActivity
        activity?.showRootLoad()
    }

    protected fun hideRootLoad() {
        val activity = activity as? DiMoxyActivity
        activity?.hideRootLoad()
    }

    protected open fun onViewPrepare(savedInstanceState: Bundle?) {

    }

    protected open fun onViewDestroyed() {
        hideRootLoad()
    }

    override fun hideContentAndParallax() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showContentAndParallax() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorDialog(title: String, message: String, action: () -> Unit, canceleble: Boolean) {
        val dialog = CustomDialog(title, message, "Повторить", action, FragmentMvpInterface.DIALOG_TYPE_ERROR, requireContext(), R.style.Dialog)
        dialog.setCancelable(canceleble)
        dialog.show()
    }

    override fun showErrorDialog(title: Int, message: Int, action: () -> Unit, canceleble: Boolean) {
        val dialog = CustomDialog(requireContext().getString(title), requireContext().getString(message), "Повторить", action, FragmentMvpInterface.DIALOG_TYPE_ERROR, requireContext(), R.style.Dialog)
        dialog.setCancelable(canceleble)
        dialog.show()
    }

    open fun onBackPressed(): Boolean {
        return true
    }
}