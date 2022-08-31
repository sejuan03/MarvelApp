package com.sejuandev.marvelcharactersapp.di.modules

import com.sejuandev.marvelcharactersapp.controllers.CharactersController
import com.sejuandev.marvelcharactersapp.controllers.CharactersControllerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
abstract class CharactersModule {

    @Binds
    @Named("service")
    abstract fun bindCharactersController(
        charactersControllerImpl: CharactersControllerImpl
    ): CharactersController
}
