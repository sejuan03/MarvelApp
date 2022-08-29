package com.sejuandev.marvelcharactersapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sejuandev.marvelcharactersapp.databinding.ActivityCharacterDescriptionBinding
import com.sejuandev.marvelcharactersapp.model.domain.DomainMarvelCharacter
import com.sejuandev.marvelcharactersapp.ui.CharacterComics
import com.sejuandev.marvelcharactersapp.utils.setImageURL
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class CharacterDescriptionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterDescriptionBinding
    private val groupAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycler()
        val character = intent.extras?.getParcelable<DomainMarvelCharacter>(CHARACTER)
        character?.let {
            showCharacter(it)
        }
    }

    private fun setRecycler() {
        binding.comicsContainer.adapter = groupAdapter
        binding.comicsContainer.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun showCharacter(character: DomainMarvelCharacter) {
        binding.apply {
            characterThumbnail.setImageURL(character.thumbnail, character.thumbnailExt)
            characterName.text = character.name
            characterDescription.text = character.description
            character.comics.map {
                groupAdapter.add(CharacterComics(it))
            }
        }
    }

    companion object {
        const val CHARACTER = "CHARACTER"
    }
}
