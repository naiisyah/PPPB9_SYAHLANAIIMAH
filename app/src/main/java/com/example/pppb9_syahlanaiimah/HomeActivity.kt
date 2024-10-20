package com.example.pppb9_syahlanaiimah

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        val logoutButton = findViewById<ImageButton>(R.id.logout)
        logoutButton.setOnClickListener {
            finish()
        }
        val tvWelcome = findViewById<TextView>(R.id.welcomeUser)
        val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "")

        tvWelcome.text = "$username!"

    }
}