package com.sejuandev.marvelcharactersapp.di.modules

import com.sejuandev.marvelcharactersapp.data.api.MarvelComicsRepositoryImpl
import com.sejuandev.marvelcharactersapp.domain.repository.MarvelComicsRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ComicsModule {

    @Binds
    @Reusable
    abstract fun provideMarvelComicsRepository(marvelComicsRepositoryImpl: MarvelComicsRepositoryImpl): MarvelComicsRepository
}
