package com.sejuandev.marvelcharactersapp.data

import com.sejuandev.marvelcharactersapp.constants.BASE_URL
import com.sejuandev.marvelcharactersapp.data.api.MarvelApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    lateinit var service: MarvelApi

    fun initApiService() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        service = retrofit.create(MarvelApi::class.java)
    }
}
