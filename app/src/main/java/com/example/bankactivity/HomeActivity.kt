package com.example.bankactivity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

/**
 * Ana ekran (Dashboard):
 *  - Bakiye metni ve ikonlu butonlar.
 *  - Hangi butona tıklanırsa, ilgili Activity'e Intent ile geçiş.
 */
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // "QR Payment" butonu
        val btnQrPayment = findViewById<LinearLayout>(R.id.btnQrPayment)
        btnQrPayment.setOnClickListener {
            // İleride QR tarama mantığı ekleyebilirsiniz.
        }

        // "Upload Money" => AddAmountActivity
        val btnUploadMoney = findViewById<LinearLayout>(R.id.btnUploadMoney)
        btnUploadMoney.setOnClickListener {
            val intent = Intent(this, AddAmountActivity::class.java)
            startActivity(intent)
        }

        // "Payments" => AccountInfoActivity
        val btnPayments = findViewById<LinearLayout>(R.id.btnPayments)
        btnPayments.setOnClickListener {
            val intent = Intent(this, AccountInfoActivity::class.java)
            startActivity(intent)
        }

        // "Top Up Balance" => AddAmountActivity
        val btnTopUp = findViewById<LinearLayout>(R.id.btnTopUp)
        btnTopUp.setOnClickListener {
            val intent = Intent(this, AddAmountActivity::class.java)
            startActivity(intent)
        }

        // "My Cards" => CardsActivity
        val btnMyCards = findViewById<LinearLayout>(R.id.btnMyCards)
        btnMyCards.setOnClickListener {
            val intent = Intent(this, CardsActivity::class.java)
            startActivity(intent)
        }

        // "Statistics" => StatisticsActivity
        val btnStatistics = findViewById<LinearLayout>(R.id.btnStatistics)
        btnStatistics.setOnClickListener {
            val intent = Intent(this, StatisticsActivity::class.java)
            startActivity(intent)
        }

        // Profil ikonu => ProfileActivity
        val btnProfile = findViewById<ImageButton>(R.id.btnProfile)
        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}
