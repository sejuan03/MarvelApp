package com.sejuandev.marvelcharactersapp.data.model.comics

import com.google.gson.annotations.SerializedName

data class MarvelComicsApiResponse(
    @SerializedName("data")
    val dataComics: DataComics
)
