package com.krauzze.trenersapp.di.modules

import android.app.Application
import android.content.Context
import android.content.res.AssetManager
import android.content.res.Resources
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    fun provideTheme(context: Context): Resources.Theme = context.theme

}