# Kotlin playground

[![Build Status](https://travis-ci.org/piotrpolak/kotlin-playground.svg?branch=master)](https://travis-ci.org/piotrpolak/kotlin-playground)

I started this project to document and play with various Kotlin features that first seemed to be counterintuitive or confusing when
compared to the old school Java implementations (like the ["is" property prefix disappearing in Jackson mappings](https://stackoverflow.com/questions/32270422/jackson-renames-primitive-boolean-field-by-removing-is)).

But then I feel in love in Kotlin so this repository might be outdated :)

## Running tests

```bash
./gradlew test
```
## Features tested

### JSR Validation

* [entities](src/main/kotlin/ro/polak/playground/jsr/validation)
* [test](src/test/kotlin/ro/polak/kotlin/playground/JsrValidationTest.kt)

### Jackson mapping

It shows various mapping configurations as well as the nasty "is" prefix issue described in
https://discuss.kotlinlang.org/t/kotlin-doesnt-play-nicely-with-jackson-if-the-property-name-contains-is/5798 and https://stackoverflow.com/questions/32270422/jackson-renames-primitive-boolean-field-by-removing-is

This is particularly annoying if you ignore unknown properties (by setting `DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES` to `false`) and provide default value to the `is` prefixed attibute at the DTO level - you will learn about the mismatch really late.

* [entities](src/main/kotlin/ro/polak/playground/jackson)
* [test](src/test/kotlin/ro/polak/kotlin/playground/JacksonTest.kt)
