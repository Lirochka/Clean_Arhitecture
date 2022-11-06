package com.example.cleanarhitecture.app

import android.app.Application
import com.example.cleanarhitecture.di.appModule
import com.example.cleanarhitecture.di.dataModule
import com.example.cleanarhitecture.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class App : Application() {

    //вызывается каждый раз когда стартует приложение
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)//указываем насколько подробно необходимо выводить ошибки в консоль
            androidContext(this@App)//чтобы в dataModule, в SharedPrefUserStorage могли вызывать context = applicationContext
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}