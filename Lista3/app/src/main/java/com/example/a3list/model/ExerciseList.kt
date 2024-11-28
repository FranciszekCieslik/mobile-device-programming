package com.example.a3list

import android.os.Parcelable
import com.example.a3list.model.Exercise
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExerciseList(
    val exercises: List<Exercise>,
    val subject: String,
    val grade: Float,
    val name: String
):Parcelable
