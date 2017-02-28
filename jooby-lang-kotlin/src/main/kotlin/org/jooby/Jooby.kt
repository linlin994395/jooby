package org.jooby

import kotlin.reflect.KClass
import org.jooby.spi.Server
import java.util.SortedSet

/**
 * Extension function that replace the Jooby#use(java.lang.String) function with a more appropiated
 * name.
 *
 * @param pattern Route group pattern.
 * @param init Group Initializer.
 */
fun Jooby.route(pattern: String, init: Route.Group.() -> Unit): Route.Group {
  val group = this.use(pattern)
  group.init()
  return group
}

/**
 * Creates jooby application and return it.
 *
 * <pre>
 * val app = jooby {
 *  get("/") {-> "Hi Kotlin"}
 * }
 * </pre>
 */
fun jooby(init: Jooby.() -> Unit): Jooby {
  val app = Jooby()
  app.init()
  return app
}

/**
 * Creates and run jooby application.
 *
 * <pre>
 * run(*args) {
 *  get("/") {-> "Hi Kotlin"}
 * }
 * </pre>
 */
fun run(vararg args: String, init: Jooby.() -> Unit): Unit {
  Jooby.run({ ->
    val app = Jooby()
    app.init()
    app
  }, args)
}

// Redefine functions with class arguments
// *********************************** LifeCycle **************************************************
fun <T:Any> LifeCycle.lifeCycle(klass: KClass<T>): LifeCycle {
  return this.lifeCycle(klass.java)
}

// *********************************** Jooby ******************************************************
fun <T:Any> Jooby.use(klass: KClass<T>): Route.Collection {
  return this.use(klass.java)
}

fun <T:Throwable> Router.err(klass: KClass<T>, handler: Err.Handler): Router {
  return this.err(klass.java, handler)
}

fun <T:Any> Registry.require(klass: KClass<T>): T {
  return this.require(klass.java)
}

fun <T:Any> Registry.require(name: String, klass: KClass<T>): T {
  return this.require(name, klass.java)
}

fun <T:Session.Store> Jooby.session(klass: KClass<T>): Session.Definition {
  return this.session(klass.java)
}

fun <T:Server> Jooby.server(klass: KClass<T>): Jooby {
  return this.server(klass.java)
}

// *********************************** Mutant *****************************************************
fun <T:Any> Mutant.to(type: KClass<T>): T {
  return this.to(type.java)
}

fun <T:Any> Mutant.to(type: KClass<T>, contentType: MediaType): T {
  return this.to(type.java, contentType)
}

fun <T:Any> Mutant.to(type: KClass<T>, contentType: String): T {
  return this.to(type.java, contentType)
}

fun <T:Enum<T>> Mutant.toEnum(type: KClass<T>): T {
  return this.toEnum(type.java)
}

fun <T:Any> Mutant.toList(type: KClass<T>): List<T> {
  return this.toList(type.java)
}

fun <T:Any> Mutant.toSet(type: KClass<T>): Set<T> {
  return this.toSet(type.java)
}

fun <T:Comparable<T>> Mutant.toSortedSet(type: KClass<T>): SortedSet<T> {
  return this.toSortedSet(type.java)
}

// *********************************** Request *****************************************************
fun <T:Any> Request.set(type: KClass<T>, value: Any): Request {
  return this.set(type.java, value)
}
