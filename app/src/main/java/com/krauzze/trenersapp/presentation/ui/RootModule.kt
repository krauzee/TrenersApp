package com.krauzze.trenersapp.presentation.ui

import com.krauzze.trenersapp.cicerone.animated.AnimatedNavigator
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@Module
class RootModule {

    @Provides
    @RootScope
    @RootQualifier
    fun provideRootCicerone(@RootQualifier router: Router): Cicerone<Router> = Cicerone.create(router)

    @Provides
    @RootQualifier
    fun provideRootNavigatorHolder(@RootQualifier cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.navigatorHolder

    @Provides
    @RootQualifier
    fun provideRootNavigator(mainActivity: RootActivity): Navigator =
        AnimatedNavigator(mainActivity, mainActivity.containerId)


    @Provides
    @RootScope
    @RootQualifier("cover")
    fun provideCoverRootCicerone(@RootQualifier("cover") router: Router): Cicerone<Router> = Cicerone.create(router)

    @Provides
    @RootQualifier("cover")
    fun provideCoverRootNavigatorHolder(@RootQualifier("cover") cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.navigatorHolder

    @Provides
    @RootQualifier("cover")
    fun provideRCoverRootNavigator(mainActivity: RootActivity): Navigator =
        AnimatedNavigator(mainActivity, mainActivity.coverContainerId)

}