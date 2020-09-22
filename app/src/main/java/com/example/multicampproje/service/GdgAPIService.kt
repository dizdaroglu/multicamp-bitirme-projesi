package com.example.multicampproje.service

import com.example.multicampproje.model.CommunityModelItem
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GdgAPIService {

    private val BASE_URL = "https://5f6642a143662800168e7538.mockapi.io/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(GdgAPI::class.java)

    fun getData(): Single<List<CommunityModelItem>> {
        return api.getGDG()
    }
}