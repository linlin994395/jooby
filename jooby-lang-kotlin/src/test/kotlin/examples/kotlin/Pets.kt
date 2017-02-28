package examples.kotlin

import org.jooby.mvc.*

@Path("/api/pets")
class Pets {

  @GET
  fun list(name: String): Any {
    return object {
      val name = name
    }
  }
}