package com.sejuandev.marvelcharactersapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sejuandev.marvelcharactersapp.R
import com.sejuandev.marvelcharactersapp.databinding.ComicItemBinding
import com.sejuandev.marvelcharactersapp.extensions.setImageURL

class ComicsAdapter() :
    RecyclerView.Adapter<ComicsAdapter.ComicsHolder>() {

    var comics = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ComicsHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ComicItemBinding.bind(view)
        fun bind(comic: String) {
            binding.comicThumbnail.setImageURL(comic)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.comic_item, parent, false)
        return ComicsHolder(view)
    }

    override fun onBindViewHolder(holder: ComicsHolder, position: Int) {
        holder.bind(comics[position])
    }

    override fun getItemCount(): Int = comics.size
}
