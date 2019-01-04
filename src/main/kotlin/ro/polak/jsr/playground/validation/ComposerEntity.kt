package ro.polak.jsr.playground.validation

import javax.validation.Valid

data class ComposerEntity(

    @field:Valid
    val inheritedEntityWithList: InheritedEntityWithList
)