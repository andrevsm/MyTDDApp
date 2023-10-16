package br.com.avsm.mytddapp.model

interface IUserService {
    fun addUser(login: String, password: String): String
}