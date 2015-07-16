package app

import skinny.engine._
import skinny.engine.async._
import skinny.engine.scalate._

object Hello extends SkinnyEngineServlet with ScalateSupport {

  def name = params.getOrElse("name", "Anonymous")
  def message: String = s"Hello, $name"

  // synchronous action
  get("/")(message)
  post("/")(message)

  // Scalate template engine
  get("/scalate") {
    contentType = "text/html"
    ssp("/index", "name" -> "foo")
  }

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
