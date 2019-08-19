package com.krauzze.trenersapp.presentation.ui

import dagger.Module
import dagger.Provides
import com.krauzze.trenersapp.util.AnimatedDialogNavigator
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@Module
class DialogModule {

    @Provides
    @RootScope
    @DialogQualifier
    fun provideCicerone(@DialogQualifier router: Router) : Cicerone<Router> = Cicerone.create(router)

    @Provides
    @DialogQualifier
    fun provideNavigatorHolder(@DialogQualifier cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder

    @Provides
    @DialogQualifier
    fun provideNavigator(activity: RootActivity): AnimatedDialogNavigator = AnimatedDialogNavigator(activity, activity.supportFragmentManager, activity.coverContainerId)

}