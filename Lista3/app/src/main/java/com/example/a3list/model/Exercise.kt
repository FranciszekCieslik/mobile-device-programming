package com.example.a3list.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exercise (
    val name: String,
    val content: String,
    val points: Int
):Parcelable
