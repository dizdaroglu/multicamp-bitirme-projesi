package com.example.multicampproje.service

import com.example.multicampproje.model.CommunityModel
import com.example.multicampproje.model.CommunityModelItem
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private val BASE_URL = "https://5f6642a143662800168e7538.mockapi.io/"

object ServiceBuilder {

    private val client = OkHttpClient
        .Builder()
        .build()


    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(GdgAPI::class.java)

    fun buildService(): GdgAPI {
        return retrofit
    }
}