package com.sejuandev.marvelcharactersapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sejuandev.marvelcharactersapp.controllers.CharactersController
import com.sejuandev.marvelcharactersapp.controllers.CharactersControllerImpl
import com.sejuandev.marvelcharactersapp.model.domain.MarvelEvents
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {

    private val controller: CharactersController = CharactersControllerImpl()
    private val disposable = CompositeDisposable()

    private val _data = MutableLiveData<MarvelEvents>()
    val data: LiveData<MarvelEvents> get() = _data

    fun getCharacters() {
        disposable.add(
            controller.getCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    _data.value = MarvelEvents.ShowLoading(true)
                }
                .doFinally {
                    _data.value = MarvelEvents.ShowLoading(false)
                }
                .subscribe(
                    {
                        _data.value = MarvelEvents.ShowCharacters(it)
                    }
                ) {
                    _data.value = MarvelEvents.ShowError(it.message)
                }
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}
