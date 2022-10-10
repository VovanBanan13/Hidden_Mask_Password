package extension

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ExtensionTest {

    @Test
    fun containsStringIgnoreCaseOkTest() {
        val testWord = "Test"
        val testSet = setOf(
            "test",
            "someTestWord"
        )
        assertTrue(testWord.contains(testSet, ignoreCase = true))
    }

    @Test
    fun containsStringNotIgnoreCaseOkTest() {
        val testWord = "Test"
        val testSet = setOf(
            "test",
            "someTestWord"
        )
        assertFalse(testWord.contains(testSet, ignoreCase = false))
    }

    @Test
    fun containsCollectionIgnoreCaseOkTest() {
        val testList = listOf(
            "First",
            "Second",
            "Test",
            "SomeWord",
            "LastWord"
        )
        val testSet = setOf(
            "test",
            "someTestWord"
        )
        assertTrue(testList.contains(testSet, ignoreCase = true))
    }

    @Test
    fun containsCollectionNotIgnoreCaseOkTest() {
        val testList = listOf(
            "First",
            "Second",
            "Test",
            "SomeWord",
            "LastWord"
        )
        val testSet = setOf(
            "test",
            "someTestWord"
        )
        assertFalse(testList.contains(testSet, ignoreCase = false))
    }

    @Test
    fun containsLongStringIgnoreCaseOkTest() {
        val testWord = "First, Second, Test, SomeWord, LastWord"
        val testSet = setOf(
            "test",
            "someTestWord"
        )
        assertTrue(testWord.contains(testSet, ignoreCase = true))
    }

    @Test
    fun containsLongStringNotIgnoreCaseOkTest() {
        val testWord = "First, Second, Test, SomeWord, LastWord"
        val testSet = setOf(
            "test",
            "someTestWord"
        )
        assertFalse(testWord.contains(testSet, ignoreCase = false))
    }

    @Test
    fun replaceTest() {
        val text = "First, Second, Test, SomeWord, LastWord"
        val list = text.replace(Regex("[,.!?;]"),"").split(" ")
        assertEquals(
            list,
            listOf("First", "Second", "Test", "SomeWord", "LastWord")
        )
    }
}