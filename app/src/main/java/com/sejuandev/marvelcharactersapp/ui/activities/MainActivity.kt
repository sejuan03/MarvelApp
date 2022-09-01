package com.sejuandev.marvelcharactersapp.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.sejuandev.marvelcharactersapp.adapters.CharactersAdapter
import com.sejuandev.marvelcharactersapp.adapters.OnClickListener
import com.sejuandev.marvelcharactersapp.databinding.ActivityMainBinding
import com.sejuandev.marvelcharactersapp.model.domain.DomainMarvelCharacter
import com.sejuandev.marvelcharactersapp.ui.MainViewModel
import com.sejuandev.marvelcharactersapp.usecases.MarvelCharactersState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
        lifecycleScope.launch {
            viewModel.state.collect {
                when (it) {
                    is MarvelCharactersState.ShowCharactersList -> showCharactersList(it.charactersList)
                    is MarvelCharactersState.ShowError -> showErrorMessage(it.error)
                    is MarvelCharactersState.ShowLoading -> showLoading(it.isLoading)
                }
            }
        }
    }

    private fun showCharactersList(characterList: List<DomainMarvelCharacter>) {
        binding.errorMessage.isVisible = false
        characterList.forEach() {
            adapter.addCharacters(it)
        }
    }

    private fun showLoading(show: Boolean) {
        binding.progressBar.isVisible = show
    }

    private fun showErrorMessage(message: String?) {
        binding.errorMessage.text = message
        binding.errorMessage.isVisible = true
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
