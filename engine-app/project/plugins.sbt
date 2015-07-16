resolvers += Classpaths.sbtPluginReleases
resolvers += "sonatype releases"  at "https://oss.sonatype.org/content/repositories/releases"
addMavenResolverPlugin

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

addSbtPlugin("org.skinny-framework" % "sbt-servlet-plugin" % "2.0.0")
addSbtPlugin("org.skinny-framework" % "sbt-scalate-precompiler" % "1.7.1.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.3.0")
