package com.example.lista7

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StudentDetailScreen(viewModel: StudentViewModel) {
    val student by viewModel.selectedStudent.observeAsState()

    student?.let {
        Card ( modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            shape = RoundedCornerShape(16.dp)
        )
        {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Nr Indeksu: ${it.indexNumber}")
                Text(text = "Imię: ${it.firstName}")
                Text(text = "Nazwisko: ${it.lastName}")
                Text(text = "Średnia ocen: ${it.averageGrade}")
                Text(text = "Rok studiów: ${it.studyYear}")
            }
        }
    } ?: Text(text = "Brak danych studenta")
}
