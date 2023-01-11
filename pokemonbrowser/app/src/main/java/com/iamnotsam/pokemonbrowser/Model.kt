package com.iamnotsam.pokemonbrowser

data class Movie(val name: String, val imageUrl: String, val category: String, val desc: String)

data class Card(val name: String, val id: String, val images: List<String>)
