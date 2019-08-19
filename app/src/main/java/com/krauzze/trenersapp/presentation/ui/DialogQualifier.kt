package com.krauzze.trenersapp.presentation.ui

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DialogQualifier(val name: String = "")