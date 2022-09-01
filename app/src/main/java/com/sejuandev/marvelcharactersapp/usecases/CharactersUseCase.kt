package com.sejuandev.marvelcharactersapp.usecases

import com.sejuandev.marvelcharactersapp.domain.repository.MarvelRepository
import javax.inject.Inject

class CharactersUseCase @Inject constructor(
    private val repository: MarvelRepository
) {
    fun getCharacters() = repository.getCharacters()
}
