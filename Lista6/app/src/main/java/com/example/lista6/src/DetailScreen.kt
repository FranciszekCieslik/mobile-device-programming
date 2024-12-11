package com.example.lista6.src

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.lista6.model.ExerciseList


@Composable
fun DetailScreen(exerciseList: ExerciseList) {
    Card(
        modifier = Modifier
            .fillMaxWidth()  // Wypełnia całą szerokość dostępnego miejsca
            .padding(4.dp),  // Dodaje odstęp wokół karty
        shape = RoundedCornerShape(16.dp),  // Zaokrąglone rogi karty
    ) {
        Column {
            Text(
                text = "${exerciseList.subject.name} - Lista zadań",
                style = MaterialTheme.typography.titleLarge
            )
            if (exerciseList.exercises.isEmpty()) {
                Text(
                    text = "Brak zadań do wyświetlenia",
                    style = MaterialTheme.typography.bodyMedium
                )
            } else {
                LazyColumn {
                    items(exerciseList.exercises) { exercise ->
                        ListItem(
                            headlineContent = { Text(exercise.content) },
                            supportingContent = { Text("Punkty: ${exercise.points}") }
                        )
                    }
                }
            }
        }
    }
}

