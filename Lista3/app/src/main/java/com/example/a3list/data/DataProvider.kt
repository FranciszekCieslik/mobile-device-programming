package com.example.a3list.data

import com.example.a3list.Subject
import com.example.a3list.model.Exercise
import com.example.a3list.ExerciseList

object DataProvider {

    // Lista przedmiotów
    val subjects = listOf(
        Subject(
            name = "PUM",
            grades = listOf(4.5f, 3.4f, 5f),
            exercises = listOf(
                ExerciseList(
                    subject = "PUM",
                    exercises = listOf(
                        Exercise(
                            name = "Zadanie 1",
                            content = "Tresc zadania 1",
                            points = 4
                        ),
                        Exercise(
                            name = "Zadanie 2",
                            content = "Tresc zadania 2",
                            points = 7
                        )
                    ),
                    grade = 4F,
                    name = "Lista 1"
                ),

            )
        ),
        Subject(
            name = "Matematyka",
            grades = listOf(3.0f, 4.0f, 5.0f),
            exercises = listOf(
                ExerciseList(
                    exercises = listOf(
                        Exercise(
                            name = "Zadanie 1",
                            content = "Oblicz pole powierzchni",
                            points = 8
                        ),
                        Exercise(
                            name = "Zadanie 2",
                            content = "Rozwiąż równanie kwadratowe",
                            points = 6
                        )
                    ),
                    subject = "Matematyka",
                    grade = 3F,
                    name = "Lista 1"
                )
            )
        ),
        Subject(
            name = "Fizyka",
            grades = listOf(4.0f, 3.5f, 4.8f),
            exercises = listOf(
                ExerciseList(
                    exercises = listOf(
                        Exercise(
                            name = "Zadanie 1",
                            content = "Oblicz prędkość",
                            points = 9
                        ),
                        Exercise(
                            name = "Zadanie 2",
                            content = "Wyjaśnij zasadę Newtona",
                            points = 5
                        )
                    ),
                    subject = "Fizyka",
                    grade = 2.5F,
                    name = "Lista 1"
                ),
                ExerciseList(
                    exercises = listOf(
                        Exercise(
                            name = "Zadanie 1",
                            content = "Oblicz prędkość",
                            points = 9
                        ),
                        Exercise(
                            name = "Zadanie 2",
                            content = "Wyjaśnij zasadę Newtona",
                            points = 5
                        )
                    ),
                    subject = "Fizyka",
                    grade = 2.5F,
                    name = "Lista 2"
                ),
                ExerciseList(
                    exercises = listOf(
                        Exercise(
                            name = "Zadanie 1",
                            content = "Oblicz prędkość",
                            points = 3
                        )
                    ),
                    subject = "Fizyka",
                    grade = 2.5F,
                    name = "Lista 3"
                )
            )
        ),
        Subject(
            name = "Elektronika",
            grades = listOf(3.5f, 4.5f, 4.0f),
            exercises = listOf(
                ExerciseList(
                    exercises = listOf(
                        Exercise(
                            name = "Zadanie 1",
                            content = "Narysuj układ elektroniczny",
                            points = 10
                        ),
                        Exercise(
                            name = "Zadanie 2: ",
                            content = "Oblicz opór w obwodzie",
                            points = 6
                        )
                    ),
                    subject = "Elektronika",
                    grade = 3.5F,
                    name = "Lista 1"
                )
            )
        ),
        Subject(
            name = "Algorytmy",
            grades = listOf(4.2f, 3.8f, 4.9f),
            exercises = listOf(
                ExerciseList(
                    exercises = listOf(
                        Exercise(
                            name = "Zadanie 1",
                            content = "Napisz algorytm sortowania",
                            points = 7
                        ),
                        Exercise(
                            name = "Zadanie 2",
                            content = "Opisz algorytm DFS",
                            points = 8
                        )
                    ),
                    subject = "Algorytmy",
                    grade = 4.5F,
                    name = "Lista 1"
                )
            )
        )
    )
}

