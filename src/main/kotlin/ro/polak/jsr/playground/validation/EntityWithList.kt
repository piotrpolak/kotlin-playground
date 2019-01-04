package ro.polak.jsr.playground.validation

import javax.validation.Valid

data class EntityWithList(

    @field:Valid
    val entities: List<BasicEntity> = listOf(),

    @get:Valid // Get works as well
    val otherEntities: List<BasicEntity> = listOf(),

    @Valid // Does not work, incorrect placement
    val ignored: List<BasicEntity> = listOf()
)