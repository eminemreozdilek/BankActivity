package com.example.bankactivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Profil ekranı: Kişisel bilgiler ve hesap bilgileri bölümleri.
 * "Verify" ve "Change Password" butonları.
 */
class ProfileActivity : AppCompatActivity() {
    private lateinit var etIdNumber: EditText
    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etBirthDate: EditText
    private lateinit var etPhone: EditText
    private lateinit var etAddress: EditText
    private lateinit var etCity: EditText
    private lateinit var btnVerify: Button

    private lateinit var etProfileEmail: EditText
    private lateinit var etProfilePassword: EditText
    private lateinit var btnChangePassword: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Kişisel bilgi alanları
        etIdNumber = findViewById(R.id.etIdNumber)
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etBirthDate = findViewById(R.id.etBirthDate)
        etPhone = findViewById(R.id.etPhone)
        etAddress = findViewById(R.id.etAddress)
        etCity = findViewById(R.id.etCity)
        btnVerify = findViewById(R.id.btnVerifyInfo)

        // Hesap bilgileri alanları
        etProfileEmail = findViewById(R.id.etProfileEmail)
        etProfilePassword = findViewById(R.id.etProfilePassword)
        btnChangePassword = findViewById(R.id.btnChangePassword)
        btnBack = findViewById(R.id.btnBackFromProfile)

        // Geri butonu
        btnBack.setOnClickListener { finish() }

        // Verify butonu (placeholder)
        btnVerify.setOnClickListener {
            Toast.makeText(this, "Personal info verified (placeholder)", Toast.LENGTH_SHORT).show()
        }

        // Change Password butonu (placeholder)
        btnChangePassword.setOnClickListener {
            Toast.makeText(this, "Password change (placeholder)", Toast.LENGTH_SHORT).show()
        }
    }
}
