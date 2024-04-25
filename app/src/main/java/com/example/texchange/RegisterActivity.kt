package com.example.texchange

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RegisterActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    private var REGISTER = "REGISTER"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContentView(R.layout.register_page)
        val registerButton = findViewById<Button>(R.id.RegisterButton)
        registerButton.setOnClickListener{
            val email = findViewById<EditText>(R.id.RegisterEmailInput).text.toString()
            val password = findViewById<EditText>(R.id.RegisterPasswordInput).text.toString()
            if (!email.isEmpty() && !password.isEmpty()){
                registerUser(auth, email, password)
            } else {
                Toast.makeText(this, "Email and Password can not be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerUser(auth: FirebaseAuth, email : String, password : String){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful){
                Log.d(REGISTER, "created user successfully")
                val user = auth.currentUser
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Log.w(REGISTER, "Error in creating user:", task.exception)
                Toast.makeText(
                    baseContext,
                    "Failed to create new user",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }
    }
}