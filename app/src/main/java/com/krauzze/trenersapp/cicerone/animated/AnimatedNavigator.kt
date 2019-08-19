package com.krauzze.trenersapp.cicerone.animated

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.krauzze.trenersapp.cicerone.animated.commands.AnimatedCommand
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command

open class AnimatedNavigator : SupportAppNavigator {
    constructor(activity: FragmentActivity?, containerId: Int) : super(activity, containerId)
    constructor(activity: FragmentActivity?, fragmentManager: FragmentManager?, containerId: Int) : super(
        activity,
        fragmentManager,
        containerId
    )
    override fun setupFragmentTransaction(
        command: Command?,
        currentFragment: Fragment?,
        nextFragment: Fragment?,
        fragmentTransaction: FragmentTransaction
    ) {
        if (command is AnimatedCommand) {
            fragmentTransaction.setCustomAnimations(
                command.getAnimEnter(),
                command.getAnimExit(),
                command.getAnimPopEnter(),
                command.getAnimPopExit()
            )
        }
    }

}