package com.example.pppb9_syahlanaiimah

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etLoginUsername = view.findViewById<TextInputEditText>(R.id.username)
        val etLoginPassword = view.findViewById<TextInputEditText>(R.id.password)
        val btnLogin = view.findViewById<Button>(R.id.loginButton)

        sharedPreferences = requireActivity().getSharedPreferences("user_data", AppCompatActivity.MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val username = etLoginUsername.text.toString()
            val password = etLoginPassword.text.toString()

            val editor = sharedPreferences.edit()
            editor.putString("username", username)
            editor.putString("password", password)
            editor.apply()

            // Pindah ke HomeActivity
            val intent = Intent(requireActivity(), HomeActivity::class.java)
            startActivity(intent)

        }
    }
}