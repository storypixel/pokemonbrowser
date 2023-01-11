package com.iamnotsam.pokemonbrowser

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllCards() = retrofitService.getAllCards()
}