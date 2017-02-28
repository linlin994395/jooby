# kotlin

You don't need anything special to write and run {{jooby}} applications in [Kotlin](http://kotlinlang.org/). Thanks to [Kotlin](http://kotlinlang.org/) simplicity and incredible Java integration {{jooby}} applications just works.

Having said that, we do provide a very tiny module with some functions that make a {{jooby}} application feels the language.

## dependency

```xml
<dependency>
  <groupId>org.jooby</groupId>
  <artifactId>jooby-lang-kotlin</artifactId>
  <version>{{version}}</version>
</dependency>
```

## usage

```kotlin

import org.jooby.*

fun main(args: Array<String>) {
  run(*args) {
    get("/", {-> "Hello Kotlin"})
  }
}

```

The `run` function is a [type-safe builder](http://kotlinlang.org/docs/reference/type-safe-builders.html) that initializes, bootstrap and executes a {{jooby}} application.

Optionally, you can go with the class approach we usually do in Java (of course):

```kotlin
import org.jooby.Jooby

class App: Jooby() {
  /**
   * Configure your application
   */
  init {

    get ("/") { ->
      "Hi Kotlin"
    }
  }
}

/**
 * Start Jooby
 */
fun main(args: Array<String>) {
  Jooby.run(::App, args)
}
```

We do recommend the `run` approach because not only looks better and read better but also you write less (do more, more easily).

## more examples

### JSON API

```kotlin

import org.jooby.*
import org.jooby.json.*

fun main(args: Array<String>) {
  run(*args) {

    use(Jackson())

    route("/api/pets") {
      get({
    }
  }
}

```