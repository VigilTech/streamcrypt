
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

    // Weaver Test
    libraryDependencies += "com.disneystreaming" %% "weaver-cats" % "0.7.3" % Test,

    testFrameworks += new TestFramework("weaver.framework.CatsEffect")
  )
