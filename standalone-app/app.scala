#!/usr/bin/env scalas
// or ./scalas app.scala
/***
scalaVersion := "2.11.7"
resolvers += "sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
libraryDependencies += "org.skinny-framework" %% "skinny-engine-server" % "2.0.0-SNAPSHOT"
*/
import skinny.engine._

WebServer.mount(new WebApp {
  get("/") {
    val name = params.getOrElse("name", "Anonymous")
    s"Hello, $name"
  }
}).port(8081).run()
