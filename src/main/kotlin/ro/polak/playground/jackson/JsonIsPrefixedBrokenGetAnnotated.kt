package ro.polak.playground.jackson

import com.fasterxml.jackson.annotation.JsonProperty

data class JsonIsPrefixedBrokenGetAnnotated(

    @get:JsonProperty("isBrokenAnnotated")
    val isBrokenAnnotated: Boolean? = null
)
