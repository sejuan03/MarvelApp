package com.sejuandev.marvelcharactersapp.repository

import com.sejuandev.marvelcharactersapp.data.api.MarvelApi
import com.sejuandev.marvelcharactersapp.model.domain.DomainMarvelCharacter
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
