package com.sejuandev.marvelcharactersapp.data.api

import com.sejuandev.marvelcharactersapp.domain.DomainMarvelCharacterComics
import com.sejuandev.marvelcharactersapp.domain.repository.MarvelComicsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Named

class MarvelComicsRepositoryImpl @Inject constructor(
    @Named("keymap") private val keyMap: HashMap<String, String>,
    private val service: MarvelApi
) : MarvelComicsRepository {

    override fun getMarvelComicsByID(characterId: String): Flow<List<DomainMarvelCharacterComics>> {
        return flow {
            val listOfComics = service.getMarvelCharacterComics(characterId, keyMap)
                .dataComics.comics.map {
                    DomainMarvelCharacterComics(it)
                }
            emit(listOfComics)
        }
    }
}
