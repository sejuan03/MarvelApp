package com.sejuandev.marvelcharactersapp.data.model.comics

import com.google.gson.annotations.SerializedName
import com.sejuandev.marvelcharactersapp.data.model.Thumbnail

data class MarvelCharacterComics(
    @SerializedName("title")
    val comicTitle: String,

    @SerializedName("thumbnail")
    val comicImage: Thumbnail
)
