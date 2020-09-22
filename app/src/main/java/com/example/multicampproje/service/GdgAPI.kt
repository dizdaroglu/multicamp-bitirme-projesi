package com.example.multicampproje.service

import com.example.multicampproje.model.CommunityModel
import com.example.multicampproje.model.CommunityModelItem
import io.reactivex.Single
import retrofit2.http.GET

interface GdgAPI {
    //https://5f6642a143662800168e7538.mockapi.io/multicamp/communities
    @GET("multicamp/communities")
    fun getGDG(): Single<List<CommunityModelItem>>
}