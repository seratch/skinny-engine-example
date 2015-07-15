package app

import skinny.engine._
import skinny.engine.async._

object Hello extends SkinnyEngineServlet {

  def name = params.getAs[String]("name").getOrElse("Anonymous")
  def message: String = s"Hello, $name"

  // synchronous action
  get("/")(message)
  post("/")(message)

  // asynchronous action
  get("/async") {
    AsyncResult {
      message
    }
  }

  // returns JSON response
  get("/json") {
    responseAsJSON(Map("message" -> message))
  }
  get("/json/async") {
    AsyncResult {
      responseAsJSON(Map("message" -> message))
    }
  }
}
