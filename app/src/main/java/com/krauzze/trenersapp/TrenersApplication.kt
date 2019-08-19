package com.krauzze.trenersapp

import android.support.multidex.MultiDex
import com.krauzze.trenersapp.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class TrenersApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<TrenersApplication> {

        return DaggerAppComponent.builder().application(this).create(this)

    }


    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }

}