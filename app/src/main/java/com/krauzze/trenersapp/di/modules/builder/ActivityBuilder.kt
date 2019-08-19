package com.krauzze.trenersapp.di.modules.builder

import com.krauzze.trenersapp.presentation.ui.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [RootModule::class, RootFragmentBuilder::class, DialogModule::class])
    @RootScope
    abstract fun bindMainAcitivty(): RootActivity

}