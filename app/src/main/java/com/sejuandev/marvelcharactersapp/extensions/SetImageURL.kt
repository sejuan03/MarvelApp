package com.sejuandev.marvelcharactersapp.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.setImageURL(path: String, extension: String) {
    val url = "$path.$extension"
    val urlPicasso = url.replaceFirst("http", "https", true)
    Picasso.get().load(urlPicasso).into(this)
}
