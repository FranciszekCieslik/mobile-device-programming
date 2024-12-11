package com.example.lista6.model

import kotlin.random.Random

val subjects = listOf("Matematyka", "Fizyka", "PUM", "Elektronika", "Algorytmy")

val dummyData = List(20) { index ->
    ExerciseList(
        exercises = List((1..10).random()) {
            Exercise(
                content = "Zadanie ${(1..100).random()}",
                points = (1..10).random()
            )
        },
        subject = Subject(name = subjects.random()),
        grade = Random.nextDouble(3.0, 5.0).toBigDecimal().setScale(1, java.math.RoundingMode.HALF_UP).toDouble()
    )
}
