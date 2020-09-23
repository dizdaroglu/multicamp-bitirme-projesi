package com.example.multicampproje.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Links(
    @SerializedName("instagram")
    val instagram: String,
    @SerializedName("participation")
    val participation: String,
    @SerializedName("twitter")
    val twitter: String,
    @SerializedName("youtube")
    val youtube: String
):Parcelable