package app

import skinny.engine._
import skinny.engine.async._

object Hello extends SkinnyEngineServlet with FutureSupport {
  implicit override val executor = scala.concurrent.ExecutionContext.Implicits.global

  def name = params.getAs[String]("name").getOrElse("Anonymous")
  def message = s"Hello, $name"

  get("/")(message)

  post("/")(message)

  get("/async") {
    AsyncResult {
      message
    }
  }
}
