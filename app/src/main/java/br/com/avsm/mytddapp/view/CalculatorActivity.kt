package br.com.avsm.mytddapp.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.avsm.mytddapp.R
import br.com.avsm.mytddapp.controller.DependencyInjector
import br.com.avsm.mytddapp.model.CalculatorService
import java.lang.Exception

class CalculatorActivity : AppCompatActivity() {
    lateinit var dependencyInjector: DependencyInjector
    lateinit var calculatorService: CalculatorService
    lateinit var firstNumber: String
    lateinit var secondNumber: String
    lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        dependencyInjector = DependencyInjector()
        calculatorService = dependencyInjector.provideCalculatorService()
        firstNumber = findViewById<EditText?>(R.id.num1EditText).toString()
        secondNumber = findViewById<EditText?>(R.id.num2EditText).toString()
        resultTextView = findViewById(R.id.resultTextView)

        val sumButton = findViewById<Button>(R.id.sumButton)
        sumButton.setOnClickListener {
            if (updateNumbers()) {
                resultTextView.text = calculatorService.sum(firstNumber, secondNumber)
            }
        }

        val subButton = findViewById<Button>(R.id.subButton)
        subButton.setOnClickListener {
            if (updateNumbers()) {
                resultTextView.text = calculatorService.sub(firstNumber, secondNumber)
            }
        }

        val multButton = findViewById<Button>(R.id.multButton)
        multButton.setOnClickListener {
            if (updateNumbers()) {
                resultTextView.text = calculatorService.mult(firstNumber, secondNumber)
            }
        }

        val divButton = findViewById<Button>(R.id.divButton)
        divButton.setOnClickListener {
            if (updateNumbers()) {
                resultTextView.text = calculatorService.div(firstNumber, secondNumber)
            }
        }
    }

    private fun printError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun updateNumbers(): Boolean {
        firstNumber = findViewById<EditText?>(R.id.num1EditText).text.toString()
        secondNumber = findViewById<EditText?>(R.id.num2EditText).text.toString()

        return if (firstNumber.isNotEmpty() && secondNumber.isNotEmpty() &&
            firstNumber.isNotBlank() && secondNumber.isNotBlank()) {
            true
        } else {
            printError("Preencha os números.")
            false
        }
    }
}