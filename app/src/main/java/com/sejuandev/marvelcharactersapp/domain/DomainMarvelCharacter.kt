package com.sejuandev.marvelcharactersapp.domain

import android.os.Parcelable
import com.sejuandev.marvelcharactersapp.data.model.MarvelCharacter
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainMarvelCharacter(
    val comics: List<String>,
    val description: String,
    val id: Int,
    val name: String,
    val image: String
) : Parcelable {
    constructor(marvelCharacter: MarvelCharacter) : this(
        marvelCharacter.comics.items.map {
            it.name
        },
        marvelCharacter.description,
        marvelCharacter.id,
        marvelCharacter.name,
        image = "${marvelCharacter.thumbnail.path}.${marvelCharacter.thumbnail.extension}"
    )
}
