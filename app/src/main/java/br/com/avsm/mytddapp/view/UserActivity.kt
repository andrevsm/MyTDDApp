package br.com.avsm.mytddapp.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.avsm.mytddapp.R
import br.com.avsm.mytddapp.controller.DependencyInjector
import br.com.avsm.mytddapp.model.UserService
import java.util.Locale

class UserActivity : AppCompatActivity() {

    private lateinit var editTextLogin: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonCreateAccount: Button
    private lateinit var dependencyInjector: DependencyInjector
    private lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextLogin = findViewById(R.id.editTextLogin)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonCreateAccount = findViewById(R.id.buttonCreateAccount)
        dependencyInjector = DependencyInjector()
        userService = dependencyInjector.provideUserService()

        buttonCreateAccount.setOnClickListener(View.OnClickListener {
            val login = editTextLogin.text.toString()
            val password = editTextPassword.text.toString()

            // Verificação simples: A senha deve ter pelo menos 6 caracteres
            if (password.length < 6) {
                editTextPassword.error = "A senha deve ter pelo menos 6 caracteres"
                return@OnClickListener
            }

            val message = userService.addUser(login, password)
            if (message.lowercase(Locale.ROOT).contains("sucesso")) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        })
    }
}
