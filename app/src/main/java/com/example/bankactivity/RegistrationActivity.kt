package com.example.bankactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

/**
 * Kayıt ekranı: Email ve Şifre alanları, "Register" ve "Back" butonları.
 * - Şimdilik, hangi değer girilirse girilsin "HomeActivity"'e geçiş yapılır.
 */
class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnBack = findViewById<Button>(R.id.btnBackFromRegister)

        btnRegister.setOnClickListener {
            // Burada dilediğiniz validasyonları yapabilirsiniz.
            // Şimdilik direkt HomeActivity'e geç.
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnBack.setOnClickListener {
            // Uygulamayı kapatmak için finish()
            finish()
        }
    }
}
