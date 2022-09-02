package com.sejuandev.marvelcharactersapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sejuandev.marvelcharactersapp.constants.ERROR_MESSAGE
import com.sejuandev.marvelcharactersapp.usecases.CharactersUseCase
import com.sejuandev.marvelcharactersapp.usecases.MarvelCharactersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val characters: CharactersUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<MarvelCharactersState> =
        MutableStateFlow(MarvelCharactersState.ShowLoading(true))
    val state: StateFlow<MarvelCharactersState> get() = _state

    fun getCharacters() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            val charactersList = characters.getCharacters()
            withContext(Dispatchers.Main) {
                charactersList
                    .catch { cause ->
                        _state.value =
                            MarvelCharactersState.ShowError(error = cause.message ?: ERROR_MESSAGE)
                    }
                    .onStart {
                        _state.value = MarvelCharactersState.ShowLoading(isLoading = true)
                    }
                    .onCompletion {
                        _state.value = MarvelCharactersState.ShowLoading(isLoading = false)
                    }
                    .collect() {
                        _state.value = MarvelCharactersState.ShowCharactersList(charactersList = it)
                    }
            }
        }
    }
}
