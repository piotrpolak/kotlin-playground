package ro.polak.kotlin.playground

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ro.polak.playground.jsr.validation.BasicEntity
import ro.polak.playground.jsr.validation.ComposerEntity
import ro.polak.playground.jsr.validation.EntityWithList
import ro.polak.playground.jsr.validation.InheritedEntityWithList
import javax.validation.Validation


class JsrValidationTest {

    private val factory = Validation.buildDefaultValidatorFactory()!!
    private val validator = factory.validator!!

    @Test
    fun shouldValidateBasicSuccess() {
        val violations = validator.validate(BasicEntity(name = "JoeDoe"))

        assertEquals(violations.size, 0)
    }

    @Test
    fun shouldValidateBasicError() {
        val violations = validator.validate(BasicEntity(name = null))

        assertEquals(violations.size, 1)
    }

    @Test
    fun shouldValidateEntityWithListSuccess() {
        val violations = validator.validate(
            EntityWithList(
                entities = listOf(
                    BasicEntity(
                        name = "JoeDoe"
                    )
                )
            )
        )

        assertEquals(violations.size, 0)
    }

    @Test
    fun shouldValidateEntityWithListError() {
        val violations = validator.validate(
            EntityWithList(
                entities = listOf(
                    BasicEntity(
                        name = null
                    )
                )
            )
        )

        assertEquals(violations.size, 1)

        val violation = violations.first()
        assertEquals("{javax.validation.constraints.NotEmpty.message}", violation.messageTemplate)
        assertEquals("entities[0].name", violation.propertyPath.toString())
    }

    @Test
    fun shouldValidateEntityWithListAndInheritanceError() {
        val violations = validator.validate(
            InheritedEntityWithList(
                entities = listOf(
                    BasicEntity(
                        name = null
                    )
                )
            )
        )

        assertEquals(violations.size, 1)

        val violation = violations.first()
        assertEquals("{javax.validation.constraints.NotEmpty.message}", violation.messageTemplate)
        assertEquals("entities[0].name", violation.propertyPath.toString())
    }

    @Test
    fun shouldValidateEntityWithListWithCompositionAndInheritanceError() {
        val violations = validator.validate(
            ComposerEntity(
                InheritedEntityWithList(
                    entities = listOf(
                        BasicEntity(
                            name = null
                        )
                    )
                )
            )
        )

        assertEquals(violations.size, 1)

        val violation = violations.first()
        assertEquals("{javax.validation.constraints.NotEmpty.message}", violation.messageTemplate)
        assertEquals("inheritedEntityWithList.entities[0].name", violation.propertyPath.toString())
    }


    @Test
    fun shouldValidateEntityWithMultipleListsError() {
        val violations = validator.validate(
            EntityWithList(
                entities = listOf(BasicEntity(name = null)),
                otherEntities = listOf(BasicEntity(name = null)),
                ignored = listOf(BasicEntity(name = null))
            )
        )

        assertEquals(violations.size, 2)
    }
}