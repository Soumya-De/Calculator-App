package com.example.calculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        }
        C_btn.setOnClickListener {
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
            val expression = edt.text.toString()
            if (expression.isNotEmpty()){
                val parts = expression.split(Regex("[-+x/]"))
                var result = parts[0].toDouble()
                for (i in 1 until parts.size) {
                    val operator = expression[parts[i-1].length]
                    when (operator) {
                        '+' -> result += parts[i].toDouble()
                        '-' -> result -= parts[i].toDouble()
                        'x' -> result *= parts[i].toDouble()
                        '/' -> result /= parts[i].toDouble()
                }
            }
                edt.setText(result.toString())
            }
        }
    }
}