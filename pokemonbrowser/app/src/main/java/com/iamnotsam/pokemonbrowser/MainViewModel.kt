package com.iamnotsam.pokemonbrowser

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iamnotsam.pokemonbrowser.pojo.Card
import com.iamnotsam.pokemonbrowser.pojo.CardResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val cardList = MutableLiveData<List<Card>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllCards() {

        val response = repository.getAllCards()
        response.enqueue(object : Callback<CardResponse> {
            override fun onResponse(call: Call<CardResponse>, response: Response<CardResponse>) {
                cardList.postValue(response.body()?.data!!)
            }

            override fun onFailure(call: Call<CardResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}