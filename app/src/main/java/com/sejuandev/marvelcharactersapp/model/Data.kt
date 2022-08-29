package com.sejuandev.marvelcharactersapp.model

import com.google.gson.annotations.SerializedName
import com.sejuandev.marvelcharactersapp.model.MarvelCharacter

data class Data(
    @SerializedName("results")
    val characters: List<MarvelCharacter>,

    val total: Int
)
