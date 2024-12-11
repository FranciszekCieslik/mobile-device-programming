package com.example.lista6.src

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lista6.model.ExerciseList

@Composable
fun ListScreen(data: List<ExerciseList>, navController: NavController) {
        LazyColumn {

            itemsIndexed(data) { index, item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()  // Wypełnia całą szerokość dostępnego miejsca
                        .padding(4.dp)  // Dodaje odstęp wokół karty
                        .shadow(4.dp, shape = RoundedCornerShape(8.dp)),  // Dodaje cień i zaokrąglone rogi
                shape = RoundedCornerShape(16.dp),  // Zaokrąglone rogi karty
                ) {
                    ListItem(
                        modifier = Modifier
                            .clickable {
                            navController.navigate("details_screen/$index")
                        },
                        headlineContent = { Text(item.subject.name) },
                        supportingContent = { Text("Liczba zadań: ${item.exercises.size}, Ocena: ${item.grade}") }
                    )
                }
            }

        }
}
