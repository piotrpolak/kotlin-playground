package ro.polak.playground.jackson

import com.fasterxml.jackson.annotation.JsonProperty

data class JsonIsPrefixedBrokenFieldAnnotated(

    @field:JsonProperty("isBrokenAnnotated")
    val isBrokenAnnotated: Boolean? = null
)
