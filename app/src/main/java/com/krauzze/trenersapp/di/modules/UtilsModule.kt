package com.krauzze.trenersapp.di.modules

import android.content.Context
import android.content.res.AssetManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {

    @Singleton
    @Provides
    fun provideAssetManager(context:Context ): AssetManager = context.assets


}