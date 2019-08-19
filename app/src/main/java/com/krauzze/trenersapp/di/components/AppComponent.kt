package com.krauzze.trenersapp.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import com.krauzze.trenersapp.TrenersApplication
import com.krauzze.trenersapp.di.modules.AppModule
import com.krauzze.trenersapp.di.modules.CiceroneModule
import com.krauzze.trenersapp.di.modules.UtilsModule
import com.krauzze.trenersapp.di.modules.builder.ActivityBuilder
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CiceroneModule::class,
        AppModule::class,
        UtilsModule::class,
        ActivityBuilder::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent : AndroidInjector<TrenersApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TrenersApplication>() {

        @BindsInstance
        abstract fun application(application: Application): Builder

    }

}