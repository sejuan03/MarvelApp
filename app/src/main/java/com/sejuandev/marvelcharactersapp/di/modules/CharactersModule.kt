package com.sejuandev.marvelcharactersapp.di.modules

import com.sejuandev.marvelcharactersapp.repository.MarvelRepository
import com.sejuandev.marvelcharactersapp.repository.MarvelRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CharactersModule {

    @Binds
    @Reusable
    abstract fun provideMarvelRepository(marvelRepositoryImpl: MarvelRepositoryImpl): MarvelRepository
}
