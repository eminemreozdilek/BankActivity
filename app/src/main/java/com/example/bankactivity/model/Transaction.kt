package com.example.bankactivity.model

/**
 * data class representing a bank transaction
 * @param dateTime Tarih ve saat ("YYYY-MM-DD HH:mm")
 * @param category Kategori adı (ör. "Coffee", "Tickets")
 * @param description Açıklama (ör. "Latte")
 * @param amount Double tutar (pozitif: masraf, negatif: iade/kredi)
 */
data class Transaction(
    val dateTime: String,
    val category: String,
    val description: String,
    val amount: Double
)
