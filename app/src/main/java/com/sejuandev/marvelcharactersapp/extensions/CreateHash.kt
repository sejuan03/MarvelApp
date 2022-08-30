package com.sejuandev.marvelcharactersapp.extensions

import java.math.BigInteger
import java.security.MessageDigest

fun String.createHash(privateKey: String, publicKey: String): String {
    val input = "$this$privateKey$publicKey"
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}
