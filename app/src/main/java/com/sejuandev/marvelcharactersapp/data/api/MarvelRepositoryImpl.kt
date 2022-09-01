package com.sejuandev.marvelcharactersapp.data.api

import com.sejuandev.marvelcharactersapp.domain.DomainMarvelCharacter
import com.sejuandev.marvelcharactersapp.domain.repository.MarvelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Named

class MarvelRepositoryImpl @Inject constructor(
    @Named("keymap") private val keyMap: HashMap<String, String>,
    private val service: MarvelApi
) : MarvelRepository {

    override fun getCharacters(): Flow<List<DomainMarvelCharacter>> {
        return flow {
            val listOfCharacters = service.getMarvelCharacters(
                keyMap.apply {
                    this["limit"] = "40"
                }
            )
                .data.characters.map {
                    DomainMarvelCharacter(it)
                }
            emit(listOfCharacters)
        }
    }
}
