package com.iamnotsam.pokemonbrowser

data class ImageSize(val small: String, val large: String)

// what type should "images" be?
data class Card(val name: String, val id: String, val images: ImageSize)

