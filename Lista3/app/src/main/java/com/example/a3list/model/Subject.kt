package com.example.a3list

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Subject(
    val name: String,
    val grades: List<Float>,
    val exercises: List<ExerciseList>
):Parcelable
