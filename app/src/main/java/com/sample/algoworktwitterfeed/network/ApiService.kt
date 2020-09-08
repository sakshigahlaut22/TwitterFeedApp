package com.sample.algoworktwitterfeed.network

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {

    @GET("tweets")
    fun getApiRequestsArray(): Call<JsonArray?>?

}