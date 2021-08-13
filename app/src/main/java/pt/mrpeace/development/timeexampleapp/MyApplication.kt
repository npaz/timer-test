package pt.mrpeace.development.timeexampleapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.stopKoin
import pt.mrpeace.development.timeexampleapp.di.appModule

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }


    private fun initKoin() {
        stopKoin()
        org.koin.core.context.startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}