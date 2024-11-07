package com.example.lista1_quiz_app.model

object DataProvider {
    val questions = listOf(
        Question(
            question = "What is Gilderoy Lockhart's profession at Hogwarts?",
            options = listOf("Potions Master", "Caretaker", "Defense Against the Dark Arts teacher", "Charms professor"),
            correctAnswerIndex = 2
        ),
        Question(
            question = "Which book did Gilderoy Lockhart NOT write?",
            options = listOf("Gadding with Ghouls", "Wanderings with Werewolves", "Magical Me", "A History of Magic"),
            correctAnswerIndex = 3
        ),
        Question(
            question = "What color are Gilderoy Lockhart's robes usually described as?",
            options = listOf("Pink", "Lilac", "Green", "Gold"),
            correctAnswerIndex = 1
        ),
        Question(
            question = "Which spell does Lockhart accidentally use on himself in the Chamber of Secrets?",
            options = listOf("Expelliarmus", "Obliviate", "Accio", "Petrificus Totalus"),
            correctAnswerIndex = 1
        ),
        Question(
            question = "What is Gilderoy Lockhart's favorite hobby?",
            options = listOf("Traveling", "Reading", "Signing autographs", "Gardening"),
            correctAnswerIndex = 2
        ),
        Question(
            question = "In which book does Gilderoy Lockhart first appear?",
            options = listOf("Harry Potter and the Sorcerer's Stone", "Harry Potter and the Chamber of Secrets", "Harry Potter and the Prisoner of Azkaban", "Harry Potter and the Goblet of Fire"),
            correctAnswerIndex = 1
        ),
        Question(
            question = "What is the result of the Dueling Club session between Snape and Lockhart?",
            options = listOf("Lockhart wins", "Snape wins", "It's a tie", "Lockhart forfeits"),
            correctAnswerIndex = 1
        ),
        Question(
            question = "What does Gilderoy Lockhart try to do to Harry and Ron in the Chamber of Secrets?",
            options = listOf("Teach them a spell", "Save them", "Obliviate them", "Turn them into frogs"),
            correctAnswerIndex = 2
        ),
        Question(
            question = "Which magical creature did Gilderoy Lockhart claim to have defeated in his book *Year with the Yeti*?",
            options = listOf("Werewolf", "Banshee", "Troll", "Yeti"),
            correctAnswerIndex = 3
        ),
        Question(
            question = "What ultimately happens to Lockhart at the end of *Chamber of Secrets*?",
            options = listOf("He becomes headmaster", "He leaves Hogwarts unharmed", "He loses his memory", "He joins the Order of the Phoenix"),
            correctAnswerIndex = 2
        )
    )
}



