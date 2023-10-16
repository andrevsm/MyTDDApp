package br.com.avsm.mytddapp.user

import br.com.avsm.mytddapp.model.CalculatorService
import br.com.avsm.mytddapp.controller.DependencyInjector
import br.com.avsm.mytddapp.model.UserService
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class UserTest {
    private lateinit var userService: UserService

    @Test
    fun testCreateUser() {
        val result = userService.addUser("andre", "233422")
        assertEquals(result, "Usuário criado com sucesso!")
    }

    @Test
    fun testFailCreateUser() {
        val result = userService.addUser("", "")
        assertEquals(result, "Insira o usuário e a senha!")
    }

    @Before
    fun setUp() {
        val injector = DependencyInjector()
        userService = injector.provideUserService()
    }
}