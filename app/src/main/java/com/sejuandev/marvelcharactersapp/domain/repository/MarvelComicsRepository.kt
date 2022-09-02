package com.sejuandev.marvelcharactersapp.domain.repository

import com.sejuandev.marvelcharactersapp.domain.DomainMarvelCharacterComics
import kotlinx.coroutines.flow.Flow

interface MarvelComicsRepository {
    fun getMarvelComicsByID(characterId: String): Flow<List<DomainMarvelCharacterComics>>
}
