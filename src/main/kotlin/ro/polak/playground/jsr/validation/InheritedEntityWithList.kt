package ro.polak.playground.jsr.validation

/*data*/ class InheritedEntityWithList(

    entities: List<BasicEntity> = listOf(),

    otherEntities: List<BasicEntity> = listOf(),

    ignored: List<BasicEntity> = listOf()

) : EntityWithListForInheritance(entities, otherEntities, ignored)