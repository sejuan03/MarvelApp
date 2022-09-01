package com.sejuandev.marvelcharactersapp.di.modules

import com.sejuandev.marvelcharactersapp.constants.BASE_URL
import com.sejuandev.marvelcharactersapp.constants.PRIVATE_KEY
import com.sejuandev.marvelcharactersapp.constants.PUBLIC_KEY
import com.sejuandev.marvelcharactersapp.data.api.MarvelApi
import com.sejuandev.marvelcharactersapp.extensions.createHash
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.Timestamp
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): MarvelApi {
        return retrofit.create(MarvelApi::class.java)
    }

    @Provides
    @Named("keymap")
    fun provideKeyMap(): HashMap<String, String> {
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        val hash = timeStamp.createHash(PRIVATE_KEY, PUBLIC_KEY)
        return hashMapOf<String, String>().apply {
            this["apikey"] = PUBLIC_KEY
            this["hash"] = hash
            this["ts"] = timeStamp
        }
    }
}
