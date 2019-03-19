# Kotlin playground

[![Build Status](https://travis-ci.org/piotrpolak/kotlin-playground.svg?branch=master)](https://travis-ci.org/piotrpolak/kotlin-playground)

Testing various Java features under Kotlin.

## Running tests

```bash
./gradlew test
```
## Features tested

### JSR Validation

* [entities](src/main/kotlin/ro/polak/playground/jsr/validation)
* [test](src/test/kotlin/ro/polak/kotlin/playground/JsrValidationTest.kt)


### Jackson mapping

It shows various mapping configurations as well as the nasty "is" prefix issue
[https://discuss.kotlinlang.org/t/kotlin-doesnt-play-nicely-with-jackson-if-the-property-name-contains-is/5798](https://discuss.kotlinlang.org/t/kotlin-doesnt-play-nicely-with-jackson-if-the-property-name-contains-is/5798)

* [entities](src/main/kotlin/ro/polak/playground/jackson)
* [test](src/test/kotlin/ro/polak/kotlin/playground/JacksonTest.kt)
