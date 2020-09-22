package com.example.multicampproje.model

import com.google.gson.annotations.SerializedName

data class Leader(
    @SerializedName("name")
    val name: String,
    @SerializedName("photo")
    val photo: String
)