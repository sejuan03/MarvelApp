package com.sejuandev.marvelcharactersapp.domain.repository

import com.sejuandev.marvelcharactersapp.domain.DomainMarvelCharacter
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getCharacters(): Flow<List<DomainMarvelCharacter>>
}
