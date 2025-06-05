package com.example.bankactivity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Bakiye ekleme ekranı: Kullanıcıdan tutar al, "Add" butonuna basıldığında geri HomeActivity'e dön.
 */
class AddAmountActivity : AppCompatActivity() {
    private lateinit var etAmount: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_amount)

        etAmount = findViewById(R.id.etAmount)
        btnAdd = findViewById(R.id.btnAddAmount)
        btnBack = findViewById(R.id.btnBackFromAddAmount)

        // Geri butonu
        btnBack.setOnClickListener { finish() }

        // "Add" butonu
        btnAdd.setOnClickListener {
            val input = etAmount.text.toString()
            val amount = input.toDoubleOrNull()
            if (amount == null || amount <= 0) {
                Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show()
            } else {
                // Geçici olarak sadece Toast gösteriyoruz.
                // Burada veritabanına ya da balance değişkenine ekleme yapabilirsiniz.
                Toast.makeText(this, "Added ₽ $amount to balance", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
