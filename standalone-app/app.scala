#!/usr/bin/env scalas
// or ./scalas app.scala
/***
scalaVersion := "2.11.7"
resolvers += "sonatype snapshots" at "https://oss.sonatype.org/content/repositories/releases"
libraryDependencies += "org.skinny-framework" %% "skinny-engine-server" % "2.0.0.M1-20150718"
*/
import skinny.engine._
import scala.concurrent._

WebServer.mount(new WebApp {
  get("/") {
    val name = params.getOrElse("name", "Anonymous")
    s"Hello, $name"
  }
}).mount(new AsyncWebApp {
  get("/async") { implicit ctx =>
    Future {
      responseAsJSON(params)
    }
  }
}).port(8081).run()
