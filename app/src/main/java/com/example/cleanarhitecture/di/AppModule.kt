package com.example.cleanarhitecture.di

import com.example.cleanarhitecture.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

//Будут зависимости, которые относятся к модолю app

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            getUserNameUseCase = get(),
            saveUserNameUserCase = get()
        )
    }
}