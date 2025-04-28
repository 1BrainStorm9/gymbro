package com.kirill_nikolaenko.gymbro.ui.di

import com.kirill_nikolaenko.gymbro.ui.screen.login.LoginViewModel
import com.kirill_nikolaenko.gymbro.ui.screen.register.RegisterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

var appModule = module {
    viewModelOf(::LoginViewModel)
    viewModelOf(::RegisterViewModel)
}