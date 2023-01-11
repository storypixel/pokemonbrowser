package com.iamnotsam.pokemonbrowser

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val cardList = MutableLiveData<List<Card>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllCards() {

        val response = repository.getAllCards()
        response.enqueue(object : Callback<List<Card>> {
            override fun onResponse(call: Call<List<Card>>, response: Response<List<Card>>) {
                Log.d("BLAH", response.body().toString())
                cardList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Card>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}