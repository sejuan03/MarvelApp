package com.sejuandev.marvelcharactersapp.data.api

import com.sejuandev.marvelcharactersapp.constants.PUBLIC_CHARACTERS
import com.sejuandev.marvelcharactersapp.model.MarvelApiResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MarvelApi {
    @GET(PUBLIC_CHARACTERS)
    suspend fun getMarvelCharacters(@QueryMap keyMap: HashMap<String, String>): MarvelApiResponse
}
