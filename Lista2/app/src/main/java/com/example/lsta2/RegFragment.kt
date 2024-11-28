package com.example.lsta2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.lsta2.model.UserProvider
import com.example.lsta2.model.User

class RegFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reg, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Przykład przycisku rejestracji (pobierz odpowiednie referencje do pól)
        val registerButton: Button = view.findViewById(R.id.registerUserButton)
        val nameInput: EditText = view.findViewById(R.id.usernameInput)
        val passwordInput: EditText = view.findViewById(R.id.passwordInput)

        registerButton.setOnClickListener {
            // Pobierz dane użytkownika z pól
            val name = nameInput.text.toString()
            val password = passwordInput.text.toString()

            // Walidacja danych
            if (name.isNotBlank() && password.isNotBlank()) {
                // Stwórz nowy obiekt User
                val newUser = User(name = name, password = password)

                // Dodaj użytkownika do UserProvider
                UserProvider.addUser(newUser)

                // Przykład: nawigacja do ekranu głównego
                 findNavController().navigate(R.id.action_fragment_reg_to_fragment_log)
            } else {
                // Wyświetl komunikat o błędzie
                findNavController().navigate(R.id.action_fragment_reg_to_fragment_log)
            }
        }
    }

}