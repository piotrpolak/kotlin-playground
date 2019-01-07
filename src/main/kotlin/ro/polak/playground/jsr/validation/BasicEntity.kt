package ro.polak.playground.jsr.validation

import javax.validation.constraints.NotEmpty

data class BasicEntity(

    @field:NotEmpty
    val name: String? = null
)