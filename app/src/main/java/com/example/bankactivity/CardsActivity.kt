package com.example.bankactivity

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

/**
 * Kredi Kartları ekranı: RadioGroup içindeki kartları listele.
 * "Add Card" ve "Transfer 500₽" butonları.
 */
class CardsActivity : AppCompatActivity() {
    private lateinit var rgCardNumbers: RadioGroup
    private lateinit var rbCard1: RadioButton
    private lateinit var rbCard2: RadioButton
    private lateinit var rbCard3: RadioButton
    private lateinit var btnAddCard: Button
    private lateinit var btnTransfer: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)

        // Bileşenleri bağla
        rgCardNumbers = findViewById(R.id.rgCardNumbers)
        rbCard1 = findViewById(R.id.rbCard1)
        rbCard2 = findViewById(R.id.rbCard2)
        rbCard3 = findViewById(R.id.rbCard3)
        btnAddCard = findViewById(R.id.btnAddCard)
        btnTransfer = findViewById(R.id.btnTransfer500)
        btnBack = findViewById(R.id.btnBackFromCards)

        // İlk kart seçili
        rbCard1.isChecked = true

        // Back butonu
        btnBack.setOnClickListener { finish() }

        // Add Card (placeholder)
        btnAddCard.setOnClickListener {
            // Yeni kart ekleme ekranı eklemek isterseniz burada başlatabilirsiniz.
        }

        // Transfer 500₽ (sadece örnek, doğrudan dialog açılır)
        btnTransfer.setOnClickListener {
            val dialog = PaymentConfirmationDialog(this)
            dialog.show()
        }
    }
}
