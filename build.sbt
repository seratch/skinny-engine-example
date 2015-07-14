lazy val root = (project in file("."))
  .settings(scalariformSettings)
  .settings(servletSettings)
  .settings(
    scalaVersion := "2.11.7",
    libraryDependencies ++= Seq(
      "org.skinny-framework" %% "skinny-engine"      % skinnyVersion,
      "org.eclipse.jetty"    %  "jetty-webapp"       % jettyVersion    % "container",
      "org.eclipse.jetty"    %  "jetty-plus"         % jettyVersion    % "container",
      "javax.servlet"        %  "javax.servlet-api"  % "3.1.0"         % "container;provided;test",
      "org.skinny-framework" %% "skinny-engine-test" % skinnyVersion   % "test"
    ),
    unmanagedClasspath in Test <+= (baseDirectory) map { bd =>  Attributed.blank(bd / "src/main/webapp") } 
  )

val skinnyVersion = "2.0.0.M1-20150715"
val jettyVersion = "9.2.12.v20150709"
