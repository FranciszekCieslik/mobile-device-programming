package com.example.lista4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Greeting(name = "YOLO")
            MaterialTheme {
                QuizScreen()
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Lista4Theme {
//        Greeting("Android")
//    }
//}

// model danych
data class Question(
    val questionText: String,
    val options: List<String>,
    val correctAnswer: String
)

//dane
fun generateQuestions(): List<Question> {
    return listOf(
        Question("Jaką właściwość ciała określa przyspieszenie?", listOf("Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"), "Prędkość"),
        Question("Jakie jednostki mają prędkość?", listOf("m/s", "kg", "J", "C"), "m/s"),
        Question("Jaką właściwość określa stosunek masy do objętości?", listOf("Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"), "Gęstość"),
        Question("Co to jest prędkość światła?", listOf("300 tys. km/s", "100 tys. km/s", "200 tys. km/s", "500 tys. km/s"), "300 tys. km/s"),
        Question("Który gaz jest głównym składnikiem powietrza?", listOf("Tlen", "Azot", "Dwutlenek węgla", "Hel"), "Azot"),
        Question("Jak nazywa się najmniejsza cząstka pierwiastka chemicznego?", listOf("Atom", "Molekuła", "Proton", "Elektron"), "Atom"),
        Question("Która planeta w Układzie Słonecznym jest największa?", listOf("Ziemia", "Mars", "Jowisz", "Saturn"), "Jowisz"),
        Question("Który pierwiastek ma symbol 'H'?", listOf("Wodór", "Hel", "Węgiel", "Tlen"), "Wodór"),
        Question("Jakie jest pH czystej wody?", listOf("7", "0", "14", "5"), "7"),
        Question("Który układ w ciele człowieka odpowiada za transport krwi?", listOf("Układ nerwowy", "Układ oddechowy", "Układ krążenia", "Układ pokarmowy"), "Układ krążenia"),

    )
}

@Composable
fun QuizScreen() {
    val questions = generateQuestions()
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf("") }
    var progress by remember { mutableStateOf(0f) }
    var score by remember { mutableStateOf(0) }
    var isGameFinished by remember { mutableStateOf(false) }

    @Composable
    fun GameOverScreen(score: Int, totalQuestions: Int) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Koniec gry!",
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Twój wynik: $score/$totalQuestions",
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Button(onClick = {
                currentQuestionIndex = 0
//                score.
                progress = 0f
                isGameFinished = false
            }) {
                Text(text = "Zagraj ponownie")
            }
        }
    }

    if (isGameFinished) {
        GameOverScreen(score = score, totalQuestions = questions.size)
    } else {
        val currentQuestion = questions[currentQuestionIndex]

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            // Wyświetlanie pytania
            Text(
                text = "Pytanie ${currentQuestionIndex + 1}/${questions.size}"
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()) {
                // Pasek postępu
                LinearProgressIndicator(progress = progress)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Treść pytania
            Text(text = currentQuestion.questionText)

            Spacer(modifier = Modifier.height(16.dp))

            // Opcje odpowiedzi
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column {
                    currentQuestion.options.forEach { option ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .clickable { selectedAnswer = option }
                        ) {
                            RadioButton(
                                selected = selectedAnswer == option,
                                onClick = { selectedAnswer = option }
                            )
                            Text(text = option)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Przycisk następny
            Button(
                onClick = {
                    if (selectedAnswer == currentQuestion.correctAnswer) {
                        score += 1 // Dodaj punkt za poprawną odpowiedź
                    }
                    if (currentQuestionIndex < questions.size - 1) {
                        currentQuestionIndex += 1 // Przejdź do następnego pytania
                        progress = (currentQuestionIndex + 1) / questions.size.toFloat() // Zaktualizuj pasek postępu
                        selectedAnswer = "" // Zresetuj wybór odpowiedzi
                    } else {
                        isGameFinished = true // Oznacz zakończenie gry
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = selectedAnswer.isNotEmpty() // Przycisk aktywny tylko, gdy wybrano odpowiedź
            ) {
                Text(text = "Następne")
            }
        }
    }
}
