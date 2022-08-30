package com.sejuandev.marvelcharactersapp.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("results")
    val characters: List<MarvelCharacter>,
    val total: Int
)
