Command: 
```
gradle -i test
```
Output: 
```
TestWithResource STANDARD_ERROR
    mai 19, 2020 10:32:33 AM org.jboss.threads.Version <clinit>
    INFO: JBoss Threads version 3.1.1.Final

TestWithResource STANDARD_OUT
    The test resource has been started 1 times

TestWithResource STANDARD_ERROR
    mai 19, 2020 10:32:34 AM org.jboss.threads.Version <clinit>
    INFO: JBoss Threads version 3.1.1.Final
    mai 19, 2020 10:32:34 AM io.quarkus.runtime.Timing printStartupTime
    INFO: Quarkus 1.4.2.Final started in 0.720s. Listening on: http://0.0.0.0:8081
    mai 19, 2020 10:32:34 AM io.quarkus.runtime.Timing printStartupTime
    INFO: Profile test activated. 
    mai 19, 2020 10:32:34 AM io.quarkus.runtime.Timing printStartupTime
    INFO: Installed features: [cdi, kotlin, resteasy-jsonb]

TestWithResource > doesDependOnResource() STANDARD_OUT
    This test should start `SomeResource`  since it depends on it

TestWithoutResource > doesNotDependOnResource() STANDARD_OUT
    This test should not start `SomeResource` since it does not depend on it

Gradle Test Executor 10 STANDARD_ERROR
    mai 19, 2020 10:32:34 AM io.quarkus.runtime.Timing printStopTime
    INFO: Quarkus stopped in 0.021s
```
=> totally fine. We can see that "test resource has been started ... times" is only printed for `TestWithResource` => this is the expected behaviour

----------

Command: 
```
gradle -i clean test --tests "com.github.aesteve.quarkus.reproducers.testresources.TestWithoutResource"
```
Output:
```
TestWithoutResource STANDARD_ERROR
    mai 19, 2020 10:34:31 AM org.jboss.threads.Version <clinit>
    INFO: JBoss Threads version 3.1.1.Final

TestWithoutResource STANDARD_OUT
    The test resource has been started 1 times

TestWithoutResource STANDARD_ERROR
    mai 19, 2020 10:34:32 AM org.jboss.threads.Version <clinit>
    INFO: JBoss Threads version 3.1.1.Final
    mai 19, 2020 10:34:32 AM io.quarkus.runtime.Timing printStartupTime
    INFO: Quarkus 1.4.2.Final started in 0.801s. Listening on: http://0.0.0.0:8081
    mai 19, 2020 10:34:32 AM io.quarkus.runtime.Timing printStartupTime
    INFO: Profile test activated. 
    mai 19, 2020 10:34:32 AM io.quarkus.runtime.Timing printStartupTime
    INFO: Installed features: [cdi, kotlin, resteasy-jsonb]

TestWithoutResource > doesNotDependOnResource() STANDARD_OUT
    This test should not start `SomeResource` since it does not depend on it

Gradle Test Executor 11 STANDARD_ERROR
    mai 19, 2020 10:34:32 AM io.quarkus.runtime.Timing printStopTime
    INFO: Quarkus stopped in 0.019s

```

Here it's KO: we're running a single test, and we're not expecting it to start our TestResource, since it doesn't depend on it.
`The test resource has been started 1 times` should not appear in the logs.

Note: the same happens within IntelliJIDEA since I'm using the Gradle runner to run the tests (I guess it's the default).
