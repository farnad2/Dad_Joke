package com.farnadsoft.dadjoke

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceProvider {

    companion object{
        var BASE_URL = "https://icanhazdadjoke.com"

        fun getApiService() : RetrofitApiService {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(RetrofitApiService::class.java)

        }
    }
}