package com.krauzze.trenersapp.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.krauzze.trenersapp.R
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.*

class AnimatedDialogNavigator(activity: FragmentActivity?, val fragmentManager: FragmentManager?, containerId: Int) : SupportAppNavigator(activity, fragmentManager, containerId) {
    constructor(activity: FragmentActivity, containerId: Int) : this(activity, activity.supportFragmentManager, containerId)

    override fun setupFragmentTransaction(command: Command?, currentFragment: Fragment?, nextFragment: Fragment?, fragmentTransaction: FragmentTransaction?) {
        when (command) {
           is Forward, is Replace -> {
                fragmentTransaction?.setCustomAnimations(R.anim.dialog_enter, R.anim.dialog_enter,R.anim.dialog_exit, R.anim.dialog_exit)
            }
            else -> {
                fragmentTransaction?.setCustomAnimations(R.anim.dialog_enter, R.anim.dialog_enter,R.anim.dialog_exit, R.anim.dialog_exit)
            }
        }
    }

}