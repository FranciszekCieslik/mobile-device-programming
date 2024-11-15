package com.example.lsta2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.lsta2.model.UserProvider

class LogFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navToRegButton = view.findViewById<Button>(R.id.navToRegButton)
        navToRegButton.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_log_to_fragment_reg)
        }

        val loginButton: Button = view.findViewById(R.id.loginUserButton)
        val usernameInput: EditText = view.findViewById(R.id.loginUsernameInput)
        val passwordInput: EditText = view.findViewById(R.id.loginPasswordInput)

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (UserProvider.authenticate(username, password)) {
                findNavController().navigate(R.id.action_log_to_home)
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log, container, false)
    }

}