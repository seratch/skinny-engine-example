lazy val root = (project in file("."))
  .settings(scalariformSettings)
  .settings(servletSettings)
  .settings(
    scalaVersion := "2.11.7",
    resolvers += "sonatype releases" at "https://oss.sonatype.org/content/repositories/snapshots",
    libraryDependencies ++= Seq(
      "org.skinny-framework" %% "skinny-engine"      % skinnyVersion,
      "org.skinny-framework" %  "skinny-logback"     % "1.0.6",
      "org.eclipse.jetty"    %  "jetty-webapp"       % jettyVersion    % "container",
      "org.eclipse.jetty"    %  "jetty-plus"         % jettyVersion    % "container",
      "javax.servlet"        %  "javax.servlet-api"  % "3.1.0"         % "container;provided;test",
      "org.skinny-framework" %% "skinny-engine-test" % skinnyVersion   % "test"
    ),
    unmanagedClasspath in Test <+= (baseDirectory) map { bd =>  Attributed.blank(bd / "src/main/webapp") } 
  )

val skinnyVersion = "2.0.0-SNAPSHOT"
val jettyVersion = "9.2.12.v20150709"
