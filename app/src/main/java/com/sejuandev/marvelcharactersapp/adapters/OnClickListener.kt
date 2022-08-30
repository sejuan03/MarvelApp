package com.sejuandev.marvelcharactersapp.adapters

import com.sejuandev.marvelcharactersapp.model.domain.DomainMarvelCharacter

interface OnClickListener {
    fun onCharacterClicked(character: DomainMarvelCharacter)
}
