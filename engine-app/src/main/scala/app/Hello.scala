package app

import skinny.engine._
import skinny.engine.async._
import skinny.engine.scalate._
import scala.concurrent._

trait MessageExtractor { self: SkinnyEngineBase =>
  def message(implicit ctx: Context): String = {
    val name = params.getOrElse("name", "Anonymous")
    s"Hello, $name"
  }
}

object Hello extends WebApp with MessageExtractor {

  get("/hello")(message)

  post("/hello")(message)

  get("/hello/json") {
    responseAsJSON(Map("message" -> message))
  }
}

object AsyncHello extends AsyncWebApp with MessageExtractor with ScalateSupport {

  get("/hello/scalate") { implicit ctx =>
    contentType = "text/html"
    ssp("/index", "name" -> "foo")
  }

  get("/hello/async") { implicit ctx =>
    Future {
      message
    }
  }

  get("/hello/json/async") { implicit ctx =>
    Future {
      responseAsJSON(Map("message" -> message))
    }
  }
}
