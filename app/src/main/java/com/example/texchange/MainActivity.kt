package com.example.texchange

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.texchange.ui.theme.TexChangeTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    private final var LOGIN = "LOGIN"
    public override fun onStart(){
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null){
            reload()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContentView(R.layout.logo_page)
        val signUpTextView = findViewById<TextView>(R.id.SignUp)
        val logInButton = findViewById<Button>(R.id.LogInButton)
        logInButton.setOnClickListener {
            val email = findViewById<EditText>(R.id.EmailInput).text.toString()
            val password = findViewById<EditText>(R.id.PasswordInput).text.toString()
            logInUser(auth, email, password)
        }
        signUpTextView.setOnClickListener{
            signUpClicked()
        }
    }

    private fun signUpClicked(){
        val intent = Intent(this@MainActivity, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun logInUser(auth: FirebaseAuth, email : String, password : String){
        if (email != "" && password != ""){
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // sign in success
                    Log.d(LOGIN, "successful login")
                    val user = auth.currentUser
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Log.w(LOGIN, "Login fail", task.exception)
                    Toast.makeText(baseContext, "Authentication failed", Toast.LENGTH_SHORT,).show()
                }
            }
        } else {
            Toast.makeText(baseContext, "You are missing a required field", Toast.LENGTH_SHORT).show()
        }
    }

    private fun reload() {
    }
}


