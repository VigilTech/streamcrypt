val scalaXVersion = "3.0.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "streamcrypt",
    version := "0.1.0",

    scalaVersion := scalaXVersion,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )
