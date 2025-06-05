package com.example.bankactivity

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bankactivity.adapter.TransactionAdapter
import com.example.bankactivity.model.Transaction
import com.example.bankactivity.util.FileUtils

/**
 * Hesap Bilgileri ekranı: transactions.txt'ten okunan verileri RecyclerView ile listele.
 * En alta "Request Refund" butonu.
 */
class AccountInfoActivity : AppCompatActivity() {
    private lateinit var rvTransactions: RecyclerView
    private lateinit var btnRequestRefund: Button
    private lateinit var btnBack: Button
    private lateinit var transactions: List<Transaction>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_info)

        // View'leri bağla
        rvTransactions = findViewById(R.id.rvTransactions)
        btnRequestRefund = findViewById(R.id.btnRequestRefund)
        btnBack = findViewById(R.id.btnBackFromAccountInfo)

        // Back butonu
        btnBack.setOnClickListener { finish() }

        // transactions.txt dosyasını oku
        transactions = FileUtils.readTransactionsFromAssets(this)

        // RecyclerView yapılandırması
        rvTransactions.layoutManager = LinearLayoutManager(this)
        rvTransactions.adapter = TransactionAdapter(transactions)

        // Request Refund butonu
        btnRequestRefund.setOnClickListener { showPaymentConfirmationDialog() }
    }

    private fun showPaymentConfirmationDialog() {
        // PaymentConfirmationDialog kullanarak basit bir modal göster
        val dialog = PaymentConfirmationDialog(this)
        dialog.show()
    }
}
