package com.sejuandev.marvelcharactersapp.usecases

import com.sejuandev.marvelcharactersapp.model.domain.DomainMarvelCharacter

sealed class MarvelCharactersState {
    class ShowLoading(val isLoading: Boolean) : MarvelCharactersState()
    class ShowCharactersList(val charactersList: List<DomainMarvelCharacter>) : MarvelCharactersState()
    class ShowError(val error: String) : MarvelCharactersState()
}
