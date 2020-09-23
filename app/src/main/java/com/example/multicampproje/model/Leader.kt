package com.example.multicampproje.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Leader(
    @SerializedName("name")
    val name: String,
    @SerializedName("photo")
    val photo: String
):Parcelable