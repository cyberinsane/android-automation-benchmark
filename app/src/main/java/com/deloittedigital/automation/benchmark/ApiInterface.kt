package com.deloittedigital.automation.benchmark

import com.deloittedigital.automation.benchmark.ui.Movies
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    fun getMovies(): Call<List<Movies>>

    companion object {

        private var BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}