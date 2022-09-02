package com.sejuandev.marvelcharactersapp.domain

import com.sejuandev.marvelcharactersapp.data.model.comics.MarvelCharacterComics

data class DomainMarvelCharacterComics(
    val comics: String,
    val image: String
) {
    constructor(marvelCharacterComics: MarvelCharacterComics) : this(
        comics = marvelCharacterComics.comicTitle,
        image = "${marvelCharacterComics.comicImage.path}.${marvelCharacterComics.comicImage.extension}"
    )
}
