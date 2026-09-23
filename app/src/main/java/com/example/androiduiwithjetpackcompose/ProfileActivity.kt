package com.example.androiduiwithjetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.androiduiwithjetpackcompose.ui.theme.AndroidUIWithJetpackComposeTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidUIWithJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(
                        modifier = Modifier.padding(innerPadding),
                        user = UserPrefs.load(this),
                        onLogout = {

                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        },
                        onOpenAvatar = {
                            startActivity(Intent(this, AvatarActivity::class.java))
                        }
                    )
                }
            }
        }
    }
}