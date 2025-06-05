package com.example.bankactivity.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * Basit bir Donut (halkalı pie) grafiği çizen Custom View.
 * - setData(map, colors) ile kategori ve toplam harcama değerleri verilir.
 * - Canvas üzerinde daire çizilir.
 */
class PieChartView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var dataMap: Map<String, Double> = emptyMap()
    private var colors: List<Int> = emptyList()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val strokeWidthFraction = 0.35f // Çizgi kalınlığı oranı

    fun setData(data: Map<String, Double>, colorList: List<Int>) {
        dataMap = data
        colors = colorList
        invalidate() // View'u yeniden çiz
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (dataMap.isEmpty()) return

        // Toplam değer (mutlaka pozitif > 0)
        val total = dataMap.values.sum().takeIf { it > 0 } ?: return

        val viewWidth = width.toFloat()
        val viewHeight = height.toFloat()
        val diameter = minOf(viewWidth, viewHeight)
        val radius = diameter / 2f
        val strokeWidth = radius * strokeWidthFraction

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth

        // Çemberin çizileceği dikdörtgen
        val inset = strokeWidth / 2f
        val rect = RectF(
            viewWidth / 2f - radius + inset,
            viewHeight / 2f - radius + inset,
            viewWidth / 2f + radius - inset,
            viewHeight / 2f + radius - inset
        )

        var startAngle = -90f // Üstten başlat
        var index = 0

        dataMap.forEach { (_, amount) ->
            val sweepAngle = (amount / total * 360f).toFloat()
            paint.color = colors[index % colors.size]
            canvas.drawArc(rect, startAngle, sweepAngle, false, paint)
            startAngle += sweepAngle
            index++
        }
    }
}
