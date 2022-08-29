package com.sejuandev.marvelcharactersapp.data.api

import com.sejuandev.marvelcharactersapp.constants.PUBLIC_CHARACTERS
import com.sejuandev.marvelcharactersapp.model.MarvelApiResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MarvelApi {
    @GET(PUBLIC_CHARACTERS)
    fun getMarvelCharacters(@QueryMap keyMap: HashMap<String, String>): Single<MarvelApiResponse>
}
