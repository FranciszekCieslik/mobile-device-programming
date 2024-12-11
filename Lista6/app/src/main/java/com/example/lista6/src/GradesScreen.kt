package com.example.lista6.src

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.lista6.model.ExerciseList
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp


@Composable
fun GradesScreen(data: List<ExerciseList>) {
    LazyColumn {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()  // Wypełnia całą szerokość dostępnego miejsca
                    .padding(4.dp)  // Dodaje odstęp wokół karty
                    .shadow(4.dp, shape = RoundedCornerShape(8.dp)),  // Dodaje cień i zaokrąglone rogi
                shape = RoundedCornerShape(16.dp),  // Zaokrąglone rogi karty
            ) {
            ListItem(
                headlineContent = { Text(text = item.subject.name) },
                supportingContent = { Text(text = "Średnia: ${item.grade}") }
            )
        }
        }
    }
}
