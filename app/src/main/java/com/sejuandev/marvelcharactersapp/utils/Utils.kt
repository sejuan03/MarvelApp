package com.sejuandev.marvelcharactersapp.utils

import android.widget.ImageView
import com.sejuandev.marvelcharactersapp.constants.PRIVATE_KEY
import com.sejuandev.marvelcharactersapp.constants.PUBLIC_KEY
import com.squareup.picasso.Picasso
import java.math.BigInteger
import java.security.MessageDigest

fun createHashKey(timeStamp: String): String {
    val input = "$timeStamp$PRIVATE_KEY$PUBLIC_KEY"
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}

fun ImageView.setImageURL(path: String, extension: String) {
    val url = "$path.$extension"
    val urlPicasso = url.replaceFirst("http", "https", true)
    Picasso.get().load(urlPicasso).into(this)
}
