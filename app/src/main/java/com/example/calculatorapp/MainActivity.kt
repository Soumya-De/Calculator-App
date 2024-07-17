package com.example.calculatorapp

import android.os.Bundle
import android.view.View
import java.util.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val warning_txt = findViewById<TextView>(R.id.warning_txt)
        val edt = findViewById<EditText>(R.id.edt)
        val AC_btn = findViewById<Button>(R.id.AC_btn)
        val C_btn = findViewById<Button>(R.id.C_btn)
        val percent_btn = findViewById<Button>(R.id.percent_btn)
        val divide_btn = findViewById<Button>(R.id.divide_btn)
        val multiply_btn = findViewById<Button>(R.id.multiply_btn)
        val plus_btn = findViewById<Button>(R.id.plus_btn)
        val minus_btn = findViewById<Button>(R.id.minus_btn)
        val one_btn = findViewById<Button>(R.id.one_btn)
        val two_btn = findViewById<Button>(R.id.two_btn)
        val three_btn = findViewById<Button>(R.id.three_btn)
        val four_btn = findViewById<Button>(R.id.four_btn)
        val five_btn = findViewById<Button>(R.id.five_btn)
        val six_btn = findViewById<Button>(R.id.six_btn)
        val seven_btn = findViewById<Button>(R.id.seven_btn)
        val eight_btn = findViewById<Button>(R.id.eight_btn)
        val nine_btn = findViewById<Button>(R.id.nine_btn)
        val Double_zero_btn = findViewById<Button>(R.id.Double_zero_btn)
        val zero_btn = findViewById<Button>(R.id.zero_btn)
        val dot_btn = findViewById<Button>(R.id.dot_btn)
        val equal_btn = findViewById<Button>(R.id.equal_btn)

        one_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "1")
        }
        two_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "2")
        }
        three_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "3")
        }
        four_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "4")
        }
        five_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "5")
        }
        six_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "6")
        }
        seven_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "7")
        }
        eight_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "8")
        }
        nine_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "9")
        }
        Double_zero_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "00")
        }
        zero_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "0")
        }
        dot_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + ".")
        }
        AC_btn.setOnClickListener {
            edt.setText("")
            warning_txt.setText("")
        }
        C_btn.setOnClickListener {
            warning_txt.setText("")
            val currentText = edt.text.toString()
            if (currentText.isNotEmpty()) {
                edt.setText(currentText.substring(0, currentText.length - 1))
            }
        }
        percent_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "%")
        }
        divide_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "/")
        }
        multiply_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "x")
        }
        plus_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "+")
        }
        minus_btn.setOnClickListener {
            val currentText = edt.text.toString()
            edt.setText(currentText + "-")
        }

        equal_btn.setOnClickListener {
            var expression = edt.text.toString()
            if (expression.isNotEmpty()) {
                try {
                    if (!expression.contains(Regex("[-+x/.]"))) {
                        if (expression.endsWith("%")) {
                            expression = (expression.substring(0, expression.length - 1).toDouble() / 100).toString()
                        }
                        edt.setText(expression.toString())
                    }
                    val parts = expression.split(Regex("[-+x/]")).toMutableList()
                    if (parts[0].endsWith("%"))
                    {
                        parts[0] = (parts[0].substring(0, parts[0].length - 1).toDouble() / 100).toString()
                    }
                    var result = parts[0].toDouble()
                    var accumulatedLength = parts[0].length
                    for (i in 1 until parts.size) {
                        val operator = expression[accumulatedLength]
                        if (parts[i].endsWith("%"))
                        {
                            parts[i] = (parts[i].substring(0, parts[i].length - 1).toDouble() / 100).toString()
                        }
                        when (operator) {
                            '+' -> result += parts[i].toDouble()
                            '-' -> result -= parts[i].toDouble()
                            'x' -> result *= parts[i].toDouble()
                            '/' ->  {
                                if (parts[i].toDouble() != 0.0) {
                                    result /= parts[i].toDouble()
                                } else {
                                    warning_txt.setText("CANNOT DIVIDE BY ZERO")

                                    return@setOnClickListener
                                }
                            }
                        }
                        accumulatedLength += parts[i].length + 1
                    }
                    edt.setText(result.toString())
                } catch (e: Exception) {
                    warning_txt.setText("INVALID INPUT")
                }
            }
        }




    }
}