package ro.polak.kotlin.playground

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ro.polak.playground.jackson.*


class JacksonBrokenIsPrefixTest {

    private val mapper = jacksonObjectMapper()

    // That is sad :(
    @Test
    fun shouldBreakNoAnnotation() {
        assertThrows<UnrecognizedPropertyException> { mapper.readValue<JsonIsPrefixedBroken>("{\"isBroken\": true}") }

        assertThrows<UnrecognizedPropertyException> { mapper.readValue<JsonIsPrefixedBroken>("{\"broken\": true}") }

        assertEquals("{\"broken\":true}", mapper.writeValueAsString(JsonIsPrefixedBroken(true)))
    }

    @Test
    fun shouldHandleGetAnnotated() {
        mapper.readValue<JsonIsPrefixedBrokenGetAnnotated>("{\"isBrokenAnnotated\": true}").run {
            assertEquals(true, isBrokenAnnotated)
        }

        assertEquals("{\"isBrokenAnnotated\":true}", mapper.writeValueAsString(JsonIsPrefixedBrokenGetAnnotated(true)))
    }

    // That is redundancy
    @Test
    fun shouldHandleGetSetAnnotated() {
        mapper.readValue<JsonIsPrefixedBrokenGetSetAnnotated>("{\"isBrokenAnnotated\": true}").run {
            assertEquals(true, isBrokenAnnotated)
        }

        assertEquals(
            "{\"isBrokenAnnotated\":true}",
            mapper.writeValueAsString(JsonIsPrefixedBrokenGetSetAnnotated(true))
        )
    }

    @Test
    fun shouldHandleFieldAnnotation() {
        mapper.readValue<JsonIsPrefixedBrokenFieldAnnotated>("{\"isBrokenAnnotated\": true}").run {
            assertEquals(true, isBrokenAnnotated)
        }

        // That is sad :(
        assertEquals(
            "{\"isBrokenAnnotated\":true,\"brokenAnnotated\":true}",
            mapper.writeValueAsString(JsonIsPrefixedBrokenFieldAnnotated(true))
        )
    }

    @Test
    fun shouldHandleGenericAnnotation() {
        mapper.readValue<JsonIsPrefixedBrokenAnnotated>("{\"isBrokenAnnotated\": true}").run {
            assertEquals(true, isBrokenAnnotated)
        }

        // That is sad :(
        assertEquals("{\"brokenAnnotated\":true}", mapper.writeValueAsString(JsonIsPrefixedBrokenAnnotated(true)))
    }
}
