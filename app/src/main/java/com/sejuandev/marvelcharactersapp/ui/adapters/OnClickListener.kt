package com.sejuandev.marvelcharactersapp.ui.adapters

import com.sejuandev.marvelcharactersapp.domain.DomainMarvelCharacter

interface OnClickListener {
    fun onCharacterClicked(character: DomainMarvelCharacter)
}
