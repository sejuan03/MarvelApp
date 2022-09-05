package com.sejuandev.marvelcharactersapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sejuandev.marvelcharactersapp.common.constants.ERROR_MESSAGE
import com.sejuandev.marvelcharactersapp.domain.repository.MarvelComicsRepository
import com.sejuandev.marvelcharactersapp.usecases.MarvelCharactersComicsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CharacterDescriptionViewModel @Inject constructor(
    private val marvelComicsRepository: MarvelComicsRepository
) : ViewModel() {

    private val _state: MutableStateFlow<MarvelCharactersComicsState> =
        MutableStateFlow(MarvelCharactersComicsState.ShowCharacterComicList(emptyList()))
    val state: MutableStateFlow<MarvelCharactersComicsState> get() = _state

    fun getCharacterComics(path: String) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            val characterComics = marvelComicsRepository.getMarvelComicsByID(path)
            withContext(Dispatchers.Main) {
                characterComics
                    .catch { cause ->
                        _state.value = MarvelCharactersComicsState.ShowError(
                            error = cause.message ?: ERROR_MESSAGE
                        )
                    }
                    .collect() {
                        _state.value = MarvelCharactersComicsState.ShowCharacterComicList(characterComicsList = it)
                    }
            }
        }
    }
}
