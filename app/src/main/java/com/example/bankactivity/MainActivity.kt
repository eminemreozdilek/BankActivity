package com.example.bankactivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * MainActivity artık sadece RegistrationActivity'i açar ve kendini kapatır.
 * Uygulama açıldığında doğrudan kayıt ekranına (RegistrationActivity) yönlendirir.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)

        finish()
    }
}
