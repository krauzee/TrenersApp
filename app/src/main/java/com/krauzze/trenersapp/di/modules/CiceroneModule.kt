package com.krauzze.trenersapp.di.modules

import dagger.Module
import dagger.Provides
import com.krauzze.trenersapp.cicerone.animated.AnimatedRouter
import com.krauzze.trenersapp.presentation.ui.DialogQualifier
import com.krauzze.trenersapp.presentation.ui.RootQualifier
import com.krauzze.trenersapp.presentation.ui.main.MainQualifier
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class CiceroneModule {

    @Provides
    @Singleton
    @RootQualifier
    fun provideRootRouter(): Router = AnimatedRouter()

    @Provides
    @Singleton
    @RootQualifier("cover")
    fun provideRootCoverRouter(): Router = AnimatedRouter()


    @Provides
    @Singleton
    @MainQualifier
    fun provideMainRouter(): Router = AnimatedRouter()

    @Provides
    @Singleton
    @MainQualifier("cover")
    fun provideMainCoverRouter(): Router = AnimatedRouter()

    @Provides
    @Singleton
    @DialogQualifier
    fun provideDialogRouter(): Router = Router()


}