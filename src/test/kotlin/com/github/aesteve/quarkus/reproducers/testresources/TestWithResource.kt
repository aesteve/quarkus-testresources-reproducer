package com.github.aesteve.quarkus.reproducers.testresources

import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Test

@QuarkusTest
@QuarkusTestResource(SomeResource::class)
class TestWithResource {

    @Test
    fun doesDependOnResource() {
        println("This test should start `SomeResource`  since it depends on it")
    }

}
