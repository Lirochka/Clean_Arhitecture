package com.example.cleanarhitecture.di

import com.example.cleanarhitecture.data.repository.UserRepositoryImpl
import com.example.cleanarhitecture.data.storage.UserStorage
import com.example.cleanarhitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleancodetest.domain.repository.UserRepository
import org.koin.dsl.module


val dataModule = module {

    single<UserStorage>{
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository>{
        UserRepositoryImpl(userStorage = get())
    }
}