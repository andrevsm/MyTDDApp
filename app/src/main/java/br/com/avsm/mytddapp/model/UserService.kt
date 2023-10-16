package br.com.avsm.mytddapp.model

class UserService : IUserService {
    override fun addUser(login: String, password: String): String {
        return if (login.isNotEmpty() && password.isNotEmpty()) {
            "Usuário criado com sucesso!"
        } else {
            "Insira o usuário e a senha!"
        }
    }
}