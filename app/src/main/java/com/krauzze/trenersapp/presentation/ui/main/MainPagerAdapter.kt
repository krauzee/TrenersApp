package com.krauzze.trenersapp.presentation.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.krauzze.trenersapp.presentation.ui.main.find.FindFragment
import com.krauzze.trenersapp.presentation.ui.main.home.HomeFragment
import com.krauzze.trenersapp.presentation.ui.main.notif.NotifFragment
import com.krauzze.trenersapp.presentation.ui.main.profile.ProfileFragment

class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(p0: Int): Fragment? {
        return when (p0) {
            0 -> HomeFragment.getInstance()
            1 -> FindFragment.getInstance()
            2 -> NotifFragment.getInstance()
            3 -> ProfileFragment.getInstance()
            else -> null
        }
    }

    override fun getCount(): Int {
        return 4
    }
}