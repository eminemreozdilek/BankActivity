package com.example.bankactivity.util

import android.content.Context
import com.example.bankactivity.model.Transaction
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * `readTransactionsFromAssets`:
 *  - `transactions.txt` (assets klasöründe) her satır: dateTime,category,description,amount
 *  - Örnek: 2025-01-12 12:30,Other,Chick-Chick,100.00
 *  - Ham veriyi okuyup, List<Transaction> döner.
 */
object FileUtils {
    fun readTransactionsFromAssets(context: Context): List<Transaction> {
        val transactions = mutableListOf<Transaction>()
        try {
            val inputStream = context.assets.open("transactions.txt")
            val reader = BufferedReader(InputStreamReader(inputStream))
            var line: String? = reader.readLine()
            while (line != null) {
                if (line.isNotBlank()) {
                    val parts = line.split(",")
                    if (parts.size == 4) {
                        val dateTime = parts[0].trim()
                        val category = parts[1].trim()
                        val description = parts[2].trim()
                        val amount = parts[3].trim().toDoubleOrNull() ?: 0.0
                        transactions.add(Transaction(dateTime, category, description, amount))
                    }
                }
                line = reader.readLine()
            }
            reader.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return transactions
    }
}
