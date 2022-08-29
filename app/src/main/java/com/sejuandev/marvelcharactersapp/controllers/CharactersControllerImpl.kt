package com.sejuandev.marvelcharactersapp.controllers

import com.sejuandev.marvelcharactersapp.constants.PUBLIC_KEY
import com.sejuandev.marvelcharactersapp.data.ApiClient
import com.sejuandev.marvelcharactersapp.model.domain.DomainMarvelCharacter
import com.sejuandev.marvelcharactersapp.utils.createHashKey
import io.reactivex.rxjava3.core.Single
import java.sql.Timestamp

class CharactersControllerImpl : CharactersController {

    override fun getCharacters(): Single<List<DomainMarvelCharacter>> {
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        val keyMap = hashMapOf<String, String>()
        keyMap.apply {
            this["apikey"] = PUBLIC_KEY
            this["hash"] = createHashKey(timeStamp)
            this["ts"] = timeStamp
        }

        return ApiClient.service.getMarvelCharacters(keyMap)
            .map { response ->
                response.data.characters.map {
                    DomainMarvelCharacter(it)
                }
            }
    }
}
