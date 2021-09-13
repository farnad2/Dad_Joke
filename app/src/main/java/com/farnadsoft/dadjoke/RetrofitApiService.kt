package com.farnadsoft.dadjoke

import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitApiService {

    @Headers("Accept: application/json","User-Agent: Farnad Try II")
    @GET("/")
    fun getAJoke() : Call<JokeData>
    //fun getAJoke() : Single<JokeData>

    companion object {

        var BASE_URL = "https://icanhazdadjoke.com"

        fun create() : RetrofitApiService {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(RetrofitApiService::class.java)

        }
    }


}

