package com.example.lsta2.model

object UserProvider {

    private val users = mutableListOf<User>(
        User( name = "Alice",  password = "password123"),
        User( name = "Bob", password = "password456"),
        User( name = "Charlie",  password = "password789"),
        User( name = "Diana", password = "password101"),
        User( name = "Edward",  password = "password202")
    )

    //private val users = mutableListOf<User>()

    fun addUser(user: User) {
        users.add(user)
    }

    fun getUsers(): List<User> = users

    fun authenticate(username: String, password: String): Boolean {
        return users.any { it.name == username && it.password == password }
    }
}