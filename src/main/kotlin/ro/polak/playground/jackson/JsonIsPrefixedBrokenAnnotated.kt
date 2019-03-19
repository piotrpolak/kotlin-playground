package ro.polak.playground.jackson

import com.fasterxml.jackson.annotation.JsonProperty

data class JsonIsPrefixedBrokenAnnotated(

    @JsonProperty("isBrokenAnnotated")
    val isBrokenAnnotated: Boolean? = null
)
