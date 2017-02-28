package examples.kotlin

import org.jooby.*
import com.typesafe.config.Config

data class User(val name: String, val age: Int)

fun main(args: Array<String>) {
  run(*args) {
    use(Pets::class)

    get("/", {-> "Hello Kotlin"})

    get("/user", {-> object {
      val name = "John"
      val age = 42
    }})
  }
}
