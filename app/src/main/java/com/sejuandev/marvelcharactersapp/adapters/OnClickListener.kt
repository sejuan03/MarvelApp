package com.sejuandev.marvelcharactersapp.adapters

import com.sejuandev.marvelcharactersapp.domain.DomainMarvelCharacter

interface OnClickListener {
    fun onCharacterClicked(character: DomainMarvelCharacter)
}
