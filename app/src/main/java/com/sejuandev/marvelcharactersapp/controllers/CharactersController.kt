package com.sejuandev.marvelcharactersapp.controllers

import com.sejuandev.marvelcharactersapp.model.domain.DomainMarvelCharacter
import io.reactivex.rxjava3.core.Single

interface CharactersController {
    fun getCharacters(): Single<List<DomainMarvelCharacter>>
}
