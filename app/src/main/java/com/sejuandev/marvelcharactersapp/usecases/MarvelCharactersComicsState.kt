package com.sejuandev.marvelcharactersapp.usecases

import com.sejuandev.marvelcharactersapp.domain.DomainMarvelCharacterComics

sealed class MarvelCharactersComicsState {
    class ShowCharacterComicList(val characterComicsList: List<DomainMarvelCharacterComics>) :
        MarvelCharactersComicsState()

    class ShowError(val error: String) : MarvelCharactersComicsState()
}
