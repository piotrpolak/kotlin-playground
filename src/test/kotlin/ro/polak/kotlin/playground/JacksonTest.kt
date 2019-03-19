package ro.polak.kotlin.playground

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ro.polak.playground.jackson.JsonAnyHolder


class JacksonTest {

    private val mapper = jacksonObjectMapper()

    @Test
    fun shouldCastAnyToList() {

        val input = "{\"result\": [\"val1\", \"val2\"]}"

        // Result is of type Any
        val output = mapper.readValue<JsonAnyHolder>(input)

        @Suppress("UNCHECKED_CAST")
        val listResult = (output.result as List<String>)

        assertTrue(listResult.contains("val1"))
        assertTrue(listResult.contains("val2"))
        assertEquals(2, listResult.size)
    }


    @Test
    fun shouldNotCastAnyToList() {

        // Result is of type Any
        val output = mapper.readValue<JsonAnyHolder>("{\"result\": \"stringvalue\"}")

        @Suppress("UNCHECKED_CAST")
        assertThrows<ClassCastException> { (output.result as List<String>) }
    }
}
