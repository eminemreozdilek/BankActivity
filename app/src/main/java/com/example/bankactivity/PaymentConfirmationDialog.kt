package com.example.bankactivity

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

/**
 * Basit bir Dialog sınıfı. `dialog_payment_confirmation.xml` kullanılarak oluşturulur.
 */
class PaymentConfirmationDialog(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_payment_confirmation)
        window?.setLayout(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )

        // Bileşenleri XML'den al
        val tvDate = findViewById<TextView>(R.id.tvDialogDate)
        val tvDesc = findViewById<TextView>(R.id.tvDialogDescription)
        val tvAmount = findViewById<TextView>(R.id.tvDialogAmount)
        val btnCancel = findViewById<Button>(R.id.btnDialogCancel)
        val btnConfirm = findViewById<Button>(R.id.btnDialogConfirm)

        // Tarih/Saat'i şu anki zamana göre ayarla
        val sdf = SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH)
        val nowDate = sdf.format(Date())
        tvDate.text = "Date: $nowDate"

        // Örnek açıklama ve tutar
        tvDesc.text = "Description: Charger Device"
        tvAmount.text = "Amount: ₽ 1000.00"

        btnCancel.setOnClickListener { dismiss() }
        btnConfirm.setOnClickListener {
            // Onaylandıktan sonra sadece dialog'u kapat
            dismiss()
        }
    }
}
