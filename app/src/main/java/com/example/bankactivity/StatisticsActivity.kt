package com.example.bankactivity

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bankactivity.model.Transaction
import com.example.bankactivity.util.FileUtils
import com.example.bankactivity.views.PieChartView

/**
 * İstatistikler ekranı: solda Pasta Grafiği, sağda legend. 
 */
class StatisticsActivity : AppCompatActivity() {
    private lateinit var flPieChartContainer: FrameLayout
    private lateinit var legendContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        flPieChartContainer = findViewById(R.id.flPieChartContainer)
        legendContainer = findViewById(R.id.legendContainer)

        // transactions.txt'ten verileri oku
        val transactions: List<Transaction> = FileUtils.readTransactionsFromAssets(this)
        // Kategori bazlı toplamları hesapla
        val categoryTotals: Map<String, Double> = transactions.groupBy { it.category }
            .mapValues { entry -> entry.value.sumOf { it.amount } }

        // Renk listesi (örnek olarak 10 farklı renk)
        val colors = listOf(
            Color.parseColor("#FFC107"), // Amber
            Color.parseColor("#FFCDD2"), // Light Red
            Color.parseColor("#9C27B0"), // Purple
            Color.parseColor("#4CAF50"), // Green
            Color.parseColor("#FFEB3B"), // Yellow
            Color.parseColor("#F44336"), // Red
            Color.parseColor("#8BC34A"), // Light Green
            Color.parseColor("#03A9F4"), // Light Blue
            Color.parseColor("#E91E63"), // Pink
            Color.parseColor("#9E9E9E")  // Grey
        )

        // PieChartView örneğini oluştur ve verileri ata
        val pieChartView = PieChartView(this).apply {
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setData(categoryTotals, colors)
        }
        flPieChartContainer.addView(pieChartView)

        // Legend: her kategori için satır ekle
        var index = 0
        categoryTotals.forEach { (category, total) ->
            // Yatay LinearLayout
            val row = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    topMargin = dpToPx(8)
                }
                gravity = Gravity.CENTER_VERTICAL
            }

            // Renk kutucuğu (View)
            val colorBox = View(this).apply {
                setBackgroundColor(colors[index % colors.size])
                layoutParams = LinearLayout.LayoutParams(dpToPx(16), dpToPx(16))
            }
            row.addView(colorBox)

            // Kategori adı ve tutar TextView
            val tvLegend = TextView(this).apply {
                text = "$category: ₽ $total"
                setTextColor(Color.BLACK)
                textSize = 16f
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    leftMargin = dpToPx(8)
                }
            }
            row.addView(tvLegend)

            legendContainer.addView(row)
            index++
        }
    }

    // dp cinsinden değerleri piksele çeviren yardımcı fonksiyon
    private fun dpToPx(dp: Int): Int {
        return (dp * resources.displayMetrics.density).toInt()
    }
}
