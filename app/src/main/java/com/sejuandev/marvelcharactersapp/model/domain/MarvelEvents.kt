package com.sejuandev.marvelcharactersapp.model.domain

sealed class MarvelEvents {
    class ShowCharacters(val characterList: List<DomainMarvelCharacter>) : MarvelEvents()
    class ShowError(val message: String?) : MarvelEvents()
    class ShowLoading(val show: Boolean) : MarvelEvents()
}
