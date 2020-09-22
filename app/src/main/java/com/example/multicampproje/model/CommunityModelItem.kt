package com.example.multicampproje.model

import com.google.gson.annotations.SerializedName

data class CommunityModelItem(
    @SerializedName("banner")
    val banner: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("leader")
    val leader: Leader,
    @SerializedName("links")
    val links: Links,
    @SerializedName("name")
    val name: String
)