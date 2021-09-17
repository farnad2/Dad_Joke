package com.farnadsoft.dadjoke

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("Accept: application/json","User-Agent: FarnadSoft")
    @GET("/")
    fun getAJoke() : Single<JokeData>

    companion object {

        var BASE_URL = "https://icanhazdadjoke.com"

        fun create() : ApiService {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)

        }
    }

}

