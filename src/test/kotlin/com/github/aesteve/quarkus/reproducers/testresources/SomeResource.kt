package com.github.aesteve.quarkus.reproducers.testresources

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager
import java.util.concurrent.atomic.AtomicInteger


class SomeResource : QuarkusTestResourceLifecycleManager {

    private val counter = AtomicInteger(0)

    override fun start(): Map<String, String> {
        println("The test resource has been started ${counter.incrementAndGet()} times") //just to put a breakpoint and analyse
        return emptyMap()
    }

    override fun stop() {}
}
