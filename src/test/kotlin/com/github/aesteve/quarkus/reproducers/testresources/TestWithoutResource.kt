package com.github.aesteve.quarkus.reproducers.testresources

import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Test

@QuarkusTest
class TestWithoutResource {

    @Test
    fun doesNotDependOnResource() {
        println("This test should not start `SomeResource` since it does not depend on it")
    }

}
