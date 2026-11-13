package com.ali.timeshift

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var timeShiftOffset = 0 // بالثواني

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = android.widget.LinearLayout(this).apply {
            orientation = android.widget.LinearLayout.VERTICAL
            setPadding(50, 50, 50, 50)
            gravity = android.view.Gravity.CENTER
        }

        val titleText = TextView(this).apply {
            text = "TimeShiftali - Amlogic S905X3"
            textSize = 22f
            setPadding(0, 0, 0, 40)
        }

        val statusText = TextView(this).apply {
            text = "Offset: 0 seconds"
            textSize = 18f
            setPadding(0, 0, 0, 40)
        }

        val plusButton = Button(this).apply {
            text = "Delay Audio (+1s)"
            setOnClickListener {
                timeShiftOffset += 1
                statusText.text = "Offset: $timeShiftOffset seconds"
            }
        }

        val minusButton = Button(this).apply {
            text = "Advance Audio (-1s)"
            setOnClickListener {
                timeShiftOffset -= 1
                statusText.text = "Offset: $timeShiftOffset seconds"
            }
        }

        layout.addView(titleText)
        layout.addView(statusText)
        layout.addView(plusButton)
        layout.addView(minusButton)

        setContentView(layout)
    }
}
