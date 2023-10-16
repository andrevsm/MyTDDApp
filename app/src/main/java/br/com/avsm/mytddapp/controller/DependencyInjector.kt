package br.com.avsm.mytddapp.controller

import br.com.avsm.mytddapp.model.CalculatorService
import br.com.avsm.mytddapp.model.UserService

class DependencyInjector {
    private val calculatorService = CalculatorService()
    private val userService = UserService()

    fun provideCalculatorService(): CalculatorService {
        return calculatorService
    }

    fun provideUserService(): UserService {
        return userService
    }
}