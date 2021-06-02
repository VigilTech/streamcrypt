
val scalaXVersion = "3.0.0"
val fs2Version = "3.0.4"

lazy val root = project
  .in(file("."))
  .settings(
    name := "streamcrypt",
    version := "0.1.0",

    scalaVersion := scalaXVersion,

    libraryDependencies += "co.fs2" %% "fs2-core" % fs2Version,

    libraryDependencies += "co.fs2" %% "fs2-io" % fs2Version,

    // To be replaced with Weaver Test
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )
