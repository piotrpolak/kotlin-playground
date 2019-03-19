package ro.polak.playground.jackson

import com.fasterxml.jackson.annotation.JsonProperty

data class JsonIsPrefixedBrokenGetSetAnnotated(

    @get:JsonProperty("isBrokenAnnotated")
    @set:JsonProperty("isBrokenAnnotated")
    var isBrokenAnnotated: Boolean? = null
)
