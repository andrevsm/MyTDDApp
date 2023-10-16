package br.com.avsm.mytddapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.avsm.mytddapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculatorButton = findViewById<Button>(R.id.calculatorButton)
        val loginButton = findViewById<Button>(R.id.loginButton)

        calculatorButton.setOnClickListener {
            this.startActivity(
                Intent(this, CalculatorActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
        }

        loginButton.setOnClickListener {
            this.startActivity(
                Intent(this, UserActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
        }
    }
}