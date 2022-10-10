package app.service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ReplaceServiceTest {

    @Test
    fun replacePasswordTest() {
        val replaceService = ReplaceService()
        val inputText = "Login: Adm, Password: adm, Login mng, Password: qwerty"
        val result = replaceService.replacePassword(inputText)
        val expected = "Login: Adm, Password: ***, Login mng, Password: ******"

        assertEquals(expected, result)
    }

    @Test
    fun replaceLoginTest() {
        val replaceService = ReplaceService()
        val inputText = "Login: Adm, Password: adm, Login mng, Password: qwerty"
        val result = replaceService.replaceLogin(inputText)
        val expected = "Login: %%%, Password: adm, Login %%%, Password: qwerty"

        assertEquals(expected, result)
    }
}