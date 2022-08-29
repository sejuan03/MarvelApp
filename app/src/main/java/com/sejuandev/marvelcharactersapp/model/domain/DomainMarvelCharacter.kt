package com.sejuandev.marvelcharactersapp.model.domain

import android.os.Parcelable
import com.sejuandev.marvelcharactersapp.model.MarvelCharacter
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainMarvelCharacter(
    val comics: List<String>,
    val description: String,
    val id: Int,
    val name: String,
    val thumbnail: String,
    val thumbnailExt: String
) : Parcelable {
    constructor(marvelCharacter: MarvelCharacter) : this(
        marvelCharacter.comics.items.map {
            it.name
        },
        marvelCharacter.description,
        marvelCharacter.id,
        marvelCharacter.name,
        marvelCharacter.thumbnail.path,
        marvelCharacter.thumbnail.extension
    )
}
