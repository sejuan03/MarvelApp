package com.sejuandev.marvelcharactersapp.data.model

data class MarvelCharacter(
    val comics: Comics,
    val description: String,
    val id: Int,
    val name: String,
    val thumbnail: Thumbnail
)
