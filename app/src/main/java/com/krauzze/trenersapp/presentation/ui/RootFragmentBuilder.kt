package com.krauzze.trenersapp.presentation.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.krauzze.trenersapp.presentation.ui.main.MainFragment
import com.krauzze.trenersapp.presentation.ui.main.MainModule
import com.krauzze.trenersapp.presentation.ui.main.MainScope
import com.krauzze.trenersapp.presentation.ui.main.find.FindFragment
import com.krauzze.trenersapp.presentation.ui.main.home.HomeFragment
import com.krauzze.trenersapp.presentation.ui.main.notif.NotifFragment
import com.krauzze.trenersapp.presentation.ui.main.profile.ProfileFragment
import com.krauzze.trenersapp.presentation.ui.start.StartFragment
import com.krauzze.trenersapp.presentation.ui.start.StartModule


@Module
abstract class RootFragmentBuilder {

    @ContributesAndroidInjector(modules = [StartModule::class])
    abstract fun provideStartPageFragment(): StartFragment

    @ContributesAndroidInjector(modules = [MainModule::class])
    @MainScope
    abstract fun provideMainFragment(): MainFragment

    @ContributesAndroidInjector()
    @MainScope
    abstract fun provideHomeFragment(): HomeFragment

    @ContributesAndroidInjector()
    @MainScope
    abstract fun provideFindFragment(): FindFragment

    @ContributesAndroidInjector()
    @MainScope
    abstract fun provideNotifFragment(): NotifFragment

    @ContributesAndroidInjector()
    @MainScope
    abstract fun provideProfileFragment(): ProfileFragment

}