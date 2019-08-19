package com.krauzze.trenersapp.presentation.base

import android.app.usage.UsageEvents
import android.content.Context
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class MoxyPresenter<T : MvpView> : MvpPresenter<T>() {

    private val subscribedEventList:MutableSet<UsageEvents.Event> = HashSet()



    protected var destroyDisposable = CompositeDisposable()
    protected lateinit var context: Context

    protected fun addDisposable(disposable: Disposable) {
        destroyDisposable.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!destroyDisposable.isDisposed)
            destroyDisposable.dispose()
    }

    protected fun Disposable.disposeWhenDestroy(): Boolean {
        return destroyDisposable.add(this)
    }

    fun <T> Single<T>.subscribeAndAddDisposable(success: (T) -> Unit, error: (Throwable) -> Unit) {
        destroyDisposable.add(subscribe({
            success(it)
        }, {
            error(it)
        }))
    }


}