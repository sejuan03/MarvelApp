package com.sejuandev.marvelcharactersapp.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sejuandev.marvelcharactersapp.databinding.ActivityMainBinding
import com.sejuandev.marvelcharactersapp.model.domain.DomainMarvelCharacter
import com.sejuandev.marvelcharactersapp.model.domain.MarvelEvents
import com.sejuandev.marvelcharactersapp.ui.CharacterItem
import com.sejuandev.marvelcharactersapp.ui.MainViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()
    private val groupAdapter = GroupAdapter<GroupieViewHolder>()

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
        characterList.map {
            groupAdapter.add(CharacterItem(it))
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
        binding.charactersContainer.adapter = groupAdapter
        binding.charactersContainer.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
