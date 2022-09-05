package com.sejuandev.marvelcharactersapp.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.sejuandev.marvelcharactersapp.ui.adapters.ComicsAdapter
import com.sejuandev.marvelcharactersapp.databinding.ActivityCharacterDescriptionBinding
import com.sejuandev.marvelcharactersapp.domain.DomainMarvelCharacter
import com.sejuandev.marvelcharactersapp.domain.DomainMarvelCharacterComics
import com.sejuandev.marvelcharactersapp.common.extensions.setImageURL
import com.sejuandev.marvelcharactersapp.ui.CharacterDescriptionViewModel
import com.sejuandev.marvelcharactersapp.usecases.MarvelCharactersComicsState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterDescriptionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterDescriptionBinding
    private val viewModel: CharacterDescriptionViewModel by viewModels()
    private lateinit var adapter: ComicsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycler()
        val character = intent.extras?.getParcelable<DomainMarvelCharacter>(CHARACTER)
        character?.let {
            setObserver(it)
            viewModel.getCharacterComics(it.id.toString())
        }
    }

    private fun setObserver(character: DomainMarvelCharacter) {
        lifecycleScope.launch {
            viewModel.state.collect {
                when (it) {
                    is MarvelCharactersComicsState.ShowCharacterComicList -> showCharacter(
                        character,
                        it.characterComicsList
                    )
                    is MarvelCharactersComicsState.ShowError -> showErrorMessage(it.error)
                }
            }
        }
    }

    private fun showErrorMessage(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    private fun setRecycler() {
        adapter = ComicsAdapter()
        binding.comicsContainer.adapter = adapter
        binding.comicsContainer.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun showCharacter(
        character: DomainMarvelCharacter,
        characterComics: List<DomainMarvelCharacterComics>
    ) {
        binding.apply {
            characterThumbnail.setImageURL(character.image)
            characterName.text = character.name
            characterDescription.text = character.description
            adapter.comics = characterComics.map {
                it.image
            }
        }
    }

    companion object {
        const val CHARACTER = "CHARACTER"
    }
}
