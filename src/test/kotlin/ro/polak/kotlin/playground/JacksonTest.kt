package ro.polak.kotlin.playground

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ro.polak.playground.jackson.JsonAnyWrapper


class JacksonTest {

    @Test
    fun shouldCastAnyToList() {

        val mapper = jacksonObjectMapper()

        val input = "{\"result\": [\"val1\", \"val2\"]}"

        // Result is of type Any
        val output = mapper.readValue<JsonAnyWrapper>(input)

        val listResult = (output.result as List<String>)

        assertTrue(listResult.contains("val1"))
        assertTrue(listResult.contains("val2"))
        assertEquals(2, listResult.size)
    }


    @Test
    fun shouldNotCastAnyToList() {

        val mapper = jacksonObjectMapper()

        val input = "{\"result\": \"stringvalue\"}"

        // Result is of type Any
        val output = mapper.readValue<JsonAnyWrapper>(input)

        assertThrows<ClassCastException> { (output.result as List<String>) }
    }
}