package com.sejuandev.marvelcharactersapp.data.model.comics

import com.google.gson.annotations.SerializedName

data class DataComics(
    @SerializedName("results")
    val comics: List<MarvelCharacterComics>
)
