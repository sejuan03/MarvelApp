package com.sejuandev.marvelcharactersapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import com.sejuandev.marvelcharactersapp.R
import com.sejuandev.marvelcharactersapp.databinding.CharacterItemBinding
import com.sejuandev.marvelcharactersapp.model.domain.DomainMarvelCharacter
import com.sejuandev.marvelcharactersapp.ui.activities.CharacterDescriptionActivity
import com.sejuandev.marvelcharactersapp.utils.setImageURL
import com.xwray.groupie.viewbinding.BindableItem

class CharacterItem(private val character: DomainMarvelCharacter) :
    BindableItem<CharacterItemBinding>() {
    @SuppressLint("CheckResult")
    override fun bind(viewBinding: CharacterItemBinding, position: Int) {
        viewBinding.apply {
            characterThumbnail.setImageURL(character.thumbnail, character.thumbnailExt)
            characterName.text = character.name
            characterId.text = character.id.toString()
            onClickListener(viewBinding)
        }
    }

    override fun getLayout(): Int {
        return R.layout.character_item
    }

    override fun initializeViewBinding(view: View): CharacterItemBinding {
        return CharacterItemBinding.bind(view)
    }

    private fun onClickListener(viewBinding: CharacterItemBinding) {
        viewBinding.root.setOnClickListener {
            val intent = Intent(it.context, CharacterDescriptionActivity::class.java).apply {
                putExtra(CharacterDescriptionActivity.CHARACTER, character)
            }
            it.context.startActivity(intent)
        }
    }
}
