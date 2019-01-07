package ro.polak.playground.jsr.validation

import javax.validation.Valid

data class ComposerEntity(

    @field:Valid
    val inheritedEntityWithList: InheritedEntityWithList
)