package com.krauzze.trenersapp.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.krauzze.trenersapp.R
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.*

class AnimatedNavigator(activity: FragmentActivity?, val fragmentManager: FragmentManager?, containerId: Int) : SupportAppNavigator(activity, fragmentManager, containerId) {
    constructor(activity: FragmentActivity, containerId: Int) : this(activity, activity.supportFragmentManager, containerId)

    override fun setupFragmentTransaction(command: Command?, currentFragment: Fragment?, nextFragment: Fragment?, fragmentTransaction: FragmentTransaction?) {
        when (command) {
            is Forward, is Replace -> {
                fragmentTransaction?.setCustomAnimations(R.anim.fragment_from_end_to_start, R.anim.fragment_from_start_to_left,R.anim.fragment_from_left_to_start, R.anim.fragment_from_start_to_end)
            }
        }
    }

}