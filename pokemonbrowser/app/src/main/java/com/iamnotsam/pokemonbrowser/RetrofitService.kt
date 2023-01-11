package com.iamnotsam.pokemonbrowser

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("movielist.json")
    fun getAllMovies() : Call<List<Card>>

    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {
//https://api.pokemontcg.io/v2/cards
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.pokemontcg.io/v2/cards")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}