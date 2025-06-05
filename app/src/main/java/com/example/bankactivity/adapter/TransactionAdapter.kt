package com.example.bankactivity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bankactivity.R
import com.example.bankactivity.model.Transaction

/**
 * RecyclerView adapter for displaying a list of Transaction nesneleri.
 */
class TransactionAdapter(
    private val transactions: List<Transaction>
) : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    /**
     * ViewHolder: item_transaction.xml içindeki alanları bağlar.
     */
    class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDateTime: TextView = itemView.findViewById(R.id.tvDateTime)
        val tvCategory: TextView = itemView.findViewById(R.id.tvCategory)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transaction, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.tvDateTime.text = transaction.dateTime
        holder.tvCategory.text = transaction.category
        holder.tvDescription.text = transaction.description
        holder.tvAmount.text = "₽ ${transaction.amount}"
    }

    override fun getItemCount(): Int = transactions.size
}
