package br.com.avsm.mytddapp.model

class CalculatorService : ICalculatorService {
    override fun sum(s1: String, s2: String): String {
        val num1 = s1.toInt()
        val num2 = s2.toInt()
        return (num1 + num2).toString()
    }

    override fun sub(s1: String, s2: String): String {
        val num1 = s1.toInt()
        val num2 = s2.toInt()
        return (num1 - num2).toString()
    }

    override fun mult(s1: String, s2: String): String {
        val num1 = s1.toInt()
        val num2 = s2.toInt()
        return (num1 * num2).toString()
    }

    override fun div(s1: String, s2: String): String {
        val num1 = s1.toInt()
        val num2 = s2.toInt()
        return (num1 / num2).toString()
    }
}