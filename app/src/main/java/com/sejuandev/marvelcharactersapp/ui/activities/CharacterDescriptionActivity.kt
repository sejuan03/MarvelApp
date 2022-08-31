package com.sejuandev.marvelcharactersapp.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sejuandev.marvelcharactersapp.adapters.ComicsAdapter
import com.sejuandev.marvelcharactersapp.databinding.ActivityCharacterDescriptionBinding
import com.sejuandev.marvelcharactersapp.extensions.setImageURL
import com.sejuandev.marvelcharactersapp.model.domain.DomainMarvelCharacter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDescriptionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterDescriptionBinding
    private lateinit var adapter: ComicsAdapter

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
        adapter = ComicsAdapter()
        binding.comicsContainer.adapter = adapter
        binding.comicsContainer.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun showCharacter(character: DomainMarvelCharacter) {
        binding.apply {
            characterThumbnail.setImageURL(character.thumbnail, character.thumbnailExt)
            characterName.text = character.name
            if (character.description.isNotBlank()) {
                characterDescription.text = character.description
            } else {
                characterDescription.visibility = View.GONE
            }
            character.comics.map {
                adapter.addComics(it)
            }
        }
    }

    companion object {
        const val CHARACTER = "CHARACTER"
    }
}
