package com.sejuandev.marvelcharactersapp.data.api

import com.sejuandev.marvelcharactersapp.common.constants.CHARACTER_COMICS
import com.sejuandev.marvelcharactersapp.common.constants.PUBLIC_CHARACTERS
import com.sejuandev.marvelcharactersapp.data.model.MarvelApiResponse
import com.sejuandev.marvelcharactersapp.data.model.comics.MarvelComicsApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface MarvelApi {
    @GET(PUBLIC_CHARACTERS)
    suspend fun getMarvelCharacters(@QueryMap keyMap: HashMap<String, String>): MarvelApiResponse

    @GET(CHARACTER_COMICS)
    suspend fun getMarvelCharacterComics(
        @Path("characterId") path: String,
        @QueryMap keyMap: HashMap<String, String>
    ): MarvelComicsApiResponse
}
