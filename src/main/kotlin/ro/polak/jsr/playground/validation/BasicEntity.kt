package ro.polak.jsr.playground.validation

import javax.validation.constraints.NotEmpty

data class BasicEntity(

    @field:NotEmpty
    val name: String? = null
)