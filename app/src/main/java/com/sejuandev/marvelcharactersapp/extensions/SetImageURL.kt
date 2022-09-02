package com.sejuandev.marvelcharactersapp.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.setImageURL(imageUrl: String) {
    val urlPicasso = imageUrl.replaceFirst("http", "https", true)
    Picasso.get().load(urlPicasso).into(this)
}
