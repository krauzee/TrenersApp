package com.krauzze.trenersapp.presentation.ui

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RootQualifier(val name: String = "")