package com.example.lista7

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lista7.model.Student
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape


@Composable
fun StudentListScreen(viewModel: StudentViewModel, onStudentClick: (Student) -> Unit) {
    val students by viewModel.students.observeAsState(emptyList())

    LazyColumn (
        modifier = Modifier
            .padding(20.dp)
    ){
        items(students) { student ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onStudentClick(student)
                    },
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(modifier = Modifier.padding(16.dp)) {
                    Text(text = student.indexNumber)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "${student.firstName} ${student.lastName}")
                }
            }
        }
    }
}
