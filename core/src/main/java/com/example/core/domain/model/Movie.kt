package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val movieId: String,
    val title: String,
    val overview: String,
    val image: String,
    val favorite: Boolean
) : Parcelable