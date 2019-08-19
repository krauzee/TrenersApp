package com.krauzze.trenersapp.presentation.ui.main.find

import dagger.Module
import dagger.Provides

@Module
class FindModule {

    @Provides
    fun provideTrenersPagerAdapter(): TrenersPagerAdapter = TrenersPagerAdapter()

    @Provides
    fun provideTrenersListAdapter(): TrenersListAdapter = TrenersListAdapter()

}