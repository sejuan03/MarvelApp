package com.sejuandev.marvelcharactersapp

import android.app.Application
import com.sejuandev.marvelcharactersapp.data.ApiClient

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ApiClient.initApiService()
    }

}
