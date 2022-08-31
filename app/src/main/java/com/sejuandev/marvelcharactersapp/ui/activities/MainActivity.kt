package com.sejuandev.marvelcharactersapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sejuandev.marvelcharactersapp.adapters.CharactersAdapter
import com.sejuandev.marvelcharactersapp.adapters.OnClickListener
import com.sejuandev.marvelcharactersapp.databinding.ActivityMainBinding
import com.sejuandev.marvelcharactersapp.model.domain.DomainMarvelCharacter
import com.sejuandev.marvelcharactersapp.model.domain.MarvelEvents
import com.sejuandev.marvelcharactersapp.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycler()
        setObserver()
        viewModel.getCharacters()
    }

    private fun setObserver() {
        viewModel.data.observe(this, ::handleEvents)
    }

    private fun handleEvents(marvelEvent: MarvelEvents) = when (marvelEvent) {
        is MarvelEvents.ShowError -> showErrorMessage(marvelEvent.message)
        is MarvelEvents.ShowLoading -> showLoading(marvelEvent.show)
        is MarvelEvents.ShowCharacters -> showCharactersList(marvelEvent.characterList)
    }

    private fun showCharactersList(characterList: List<DomainMarvelCharacter>) {
        binding.errorMessage.visibility = View.GONE
        characterList.forEach() {
            adapter.addCharacters(it)
        }
    }

    private fun showLoading(show: Boolean) {
        binding.progressBar.visibility = if (show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun showErrorMessage(message: String?) {
        binding.errorMessage.text = message
        binding.errorMessage.visibility = View.VISIBLE
    }

    private fun setRecycler() {
        adapter = CharactersAdapter(this)
        binding.charactersContainer.adapter = adapter
        binding.charactersContainer.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onCharacterClicked(character: DomainMarvelCharacter) {
        val intent = Intent(this, CharacterDescriptionActivity::class.java).apply {
            putExtra(CharacterDescriptionActivity.CHARACTER, character)
        }
        this.startActivity(intent)
    }
}
