package com.example.multicampproje.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*


@Parcelize
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
):Parcelable{
    var gdgId :UUID? = null
}