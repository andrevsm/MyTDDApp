package br.com.avsm.mytddapp.model

interface ICalculatorService {
    fun sum(s1: String, s2: String): String
    fun sub(s1: String, s2: String): String
    fun mult(s1: String, s2: String): String
    fun div(s1: String, s2: String): String
}