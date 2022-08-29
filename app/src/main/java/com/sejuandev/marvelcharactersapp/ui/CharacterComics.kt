package com.sejuandev.marvelcharactersapp.ui

import android.view.View
import com.sejuandev.marvelcharactersapp.R
import com.sejuandev.marvelcharactersapp.databinding.ComicItemBinding
import com.xwray.groupie.viewbinding.BindableItem

class CharacterComics(private val comic: String) : BindableItem<ComicItemBinding>() {
    override fun bind(viewBinding: ComicItemBinding, position: Int) {
        viewBinding.characterName.text = comic
    }

    override fun getLayout(): Int {
        return R.layout.comic_item
    }

    override fun initializeViewBinding(view: View): ComicItemBinding {
        return ComicItemBinding.bind(view)
    }
}
