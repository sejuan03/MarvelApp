package com.sejuandev.marvelcharactersapp.controllers

import com.sejuandev.marvelcharactersapp.constants.PRIVATE_KEY
import com.sejuandev.marvelcharactersapp.constants.PUBLIC_KEY
import com.sejuandev.marvelcharactersapp.data.api.MarvelApi
import com.sejuandev.marvelcharactersapp.extensions.createHash
import com.sejuandev.marvelcharactersapp.model.domain.DomainMarvelCharacter
import io.reactivex.rxjava3.core.Single
import java.sql.Timestamp
import javax.inject.Inject

class CharactersControllerImpl @Inject constructor(
    private val service: MarvelApi
) : CharactersController {

    override fun getCharacters(): Single<List<DomainMarvelCharacter>> {
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        val hash = timeStamp.createHash(PRIVATE_KEY, PUBLIC_KEY)
        val keyMap = hashMapOf<String, String>()
        keyMap.apply {
            this["apikey"] = PUBLIC_KEY
            this["hash"] = hash
            this["ts"] = timeStamp
        }
        return service.getMarvelCharacters(keyMap)
            .map { response ->
                response.data.characters.map {
                    DomainMarvelCharacter(it)
                }
            }
    }
}
