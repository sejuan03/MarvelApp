package com.sejuandev.marvelcharactersapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sejuandev.marvelcharactersapp.R
import com.sejuandev.marvelcharactersapp.databinding.ComicItemBinding

class ComicsAdapter() :
    RecyclerView.Adapter<ComicsAdapter.ComicsHolder>() {

    private val comics = mutableListOf<String>()

    fun addComics(comic: String) {
        comics.add(comic)
        notifyItemInserted(itemCount - 1)
    }

    inner class ComicsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ComicItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.comic_item, parent, false)
        return ComicsHolder(view)
    }

    override fun onBindViewHolder(holder: ComicsHolder, position: Int) {
        val comic = comics[position]
        with(holder) {
            binding.comicName.text = comic
        }
    }

    override fun getItemCount(): Int = comics.size
}
