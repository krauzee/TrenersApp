package com.krauzze.trenersapp.presentation.ui.main

import com.krauzze.trenersapp.cicerone.animated.AnimatedNavigator
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@Module
class MainModule {

    @Provides
    @MainScope
    @MainQualifier
    fun provideRegistrationCicerone(@MainQualifier router: Router): Cicerone<Router> = Cicerone.create(router)

    @Provides
    @MainQualifier
    fun provideRegistrationNavigatorHolder(@MainQualifier cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.navigatorHolder

    @Provides
    @MainQualifier
    fun provideRegistrationNavigator(fragment: MainFragment): Navigator =
        AnimatedNavigator(fragment.activity, fragment.childFragmentManager, fragment.container)

    @Provides
    @MainScope
    @MainQualifier("cover")
    fun provideRegistrationCoverCicerone(@MainQualifier("cover") router: Router): Cicerone<Router> = Cicerone.create(router)

    @Provides
    @MainQualifier("cover")
    fun provideRegistrationCoverNavigatorHolder(@MainQualifier("cover") cicerone: Cicerone<Router>): NavigatorHolder =
            cicerone.navigatorHolder

    @Provides
    @MainQualifier("cover")
    fun provideRegistrationCoverNavigator(fragment: MainFragment): Navigator =
            AnimatedNavigator(fragment.activity, fragment.childFragmentManager, fragment.coverContainerWithMenu)



}