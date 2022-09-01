package com.sejuandev.marvelcharactersapp.repository

import com.sejuandev.marvelcharactersapp.model.domain.DomainMarvelCharacter
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getCharacters(): Flow<List<DomainMarvelCharacter>>
}
