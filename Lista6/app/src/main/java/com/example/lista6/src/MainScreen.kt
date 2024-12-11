package com.example.lista6.src

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lista6.model.dummyData

@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
//    val dummyData = listOf(
//        ExerciseList(
//            subject = Subject(name = "Matematyka"),
//            exercises = listOf(
//                Exercise(content = "Zadanie 1", points = 5),
//                Exercise(content = "Zadanie 2", points = 3)
//            ),
//            grade = 4.5
//        ),
//        ExerciseList(
//            subject = Subject(name = "Fizyka"),
//            exercises = listOf(
//                Exercise(content = "Zadanie 3", points = 4)
//            ),
//            grade = 4.0
//        )
//    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.List, contentDescription = "Listy zadań") },
                    label = { Text(text = "Listy zadań") },
                    selected = false,
                    onClick = { navController.navigate("list_screen") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Star, contentDescription = "Oceny") },
                    label = { Text(text = "Oceny") },
                    selected = false,
                    onClick = { navController.navigate("grades_screen") }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "list_screen",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = "list_screen") {
                ListScreen(navController = navController, data = dummyData) // Pass arguments
            }
            composable(route = "grades_screen") {
                GradesScreen(data = dummyData)
            }
            composable(route = "details_screen/{listId}") { backStackEntry ->
                val listId = backStackEntry.arguments?.getString("listId")?.toIntOrNull()
                listId?.let { id ->
                    DetailScreen(dummyData[id])
                }
            }
        }
    }
}


