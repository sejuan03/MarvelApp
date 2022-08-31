package com.sejuandev.marvelcharactersapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sejuandev.marvelcharactersapp.R
import com.sejuandev.marvelcharactersapp.databinding.CharacterItemBinding
import com.sejuandev.marvelcharactersapp.extensions.setImageURL
import com.sejuandev.marvelcharactersapp.model.domain.DomainMarvelCharacter

class CharactersAdapter(private val listener: OnClickListener) :
    RecyclerView.Adapter<CharactersAdapter.CharactersHolder>() {

    private val characters = mutableListOf<DomainMarvelCharacter>()

    fun addCharacters(character: DomainMarvelCharacter) {
        characters.add(character)
        notifyItemInserted(itemCount - 1)
    }

    inner class CharactersHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CharacterItemBinding.bind(view)

        fun setOnClickListener(character: DomainMarvelCharacter) {
            binding.root.setOnClickListener { listener.onCharacterClicked(character) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharactersHolder(view)
    }

    override fun onBindViewHolder(holder: CharactersHolder, position: Int) {
        val character = characters[position]
        with(holder) {
            setOnClickListener(character)
            binding.apply {
                characterName.text = character.name
                characterId.text = character.id.toString()
                characterThumbnail.setImageURL(character.thumbnail, character.thumbnailExt)
            }
        }
    }

    override fun getItemCount(): Int = characters.size
}
