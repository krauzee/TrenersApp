package com.krauzze.trenersapp.util

import android.annotation.SuppressLint
import android.content.Context
import android.support.design.widget.Snackbar
import android.view.View
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SnackbarFactory @Inject constructor() {

    @Inject
    lateinit var context: Context

    @SuppressLint("RestrictedApi")
    fun getErrorSnackbar(view: View, error: String): Snackbar {
        return Snackbar.make(view, error, Snackbar.LENGTH_SHORT)
    }

    @SuppressLint("RestrictedApi")
    fun getErrorSnackbar(view: View, error: Int): Snackbar {
        return Snackbar.make(view, error, Snackbar.LENGTH_SHORT)
    }

    fun getSnackbar(view: View, text: String): Snackbar {
        return Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
    }

    fun getSnackbar(view: View, text: Int): Snackbar {
        return Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
    }

}