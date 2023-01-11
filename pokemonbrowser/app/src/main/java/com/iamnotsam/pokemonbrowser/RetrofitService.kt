package com.iamnotsam.pokemonbrowser

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("cards")
    fun getAllCards() : Call<List<Card>>

    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.pokemontcg.io/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}